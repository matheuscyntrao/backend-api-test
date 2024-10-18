package stepdef.crossover.cliente;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.crossover.ClienteCartao;
import dataProvider.domino.OrderGenerate;
import entity.digital.authentication.UsuarioLoginEntity;
import helpers.Cartao;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.request.PostClientesIdclienteCartoesRequest_v2;
import model.crossover.cliente.response.GetClientePipClientesCpfResponse_v2;
import model.crossover.cliente.response.GetClientesCartaoResponse_v2;
import model.crossover.cliente.response.PostClientesIdclienteCartoesResponse_v2;
import model.domino.order.request.PostEcommerceOrderRequest_v1;
import queries.digital.authentication.UsuariosLoginQuerie;
import service.crossover.cliente.Clientev2;
import service.crossover.cliente.Clientev2Pip;
import service.domino.order.OrderV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostClientesIdclienteCartoes_v2Steps {
    @Dado("possuo dados para Cliente - v2 - PostClientesIdclienteCartoes:")
    public void possuo_dados_para_cliente_v2_post_clientes_idcliente_cartoes(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Clientev2.POST_CLIENTES_IDCLIENTE_CARTOES), CucumberUtils.getObjectBody(dataTable, PostClientesIdclienteCartoesRequest_v2.class));
    }

    @Dado("possuo dados para Cliente - v2 - PostClientesIdclienteCartoes path:")
    public void possuo_dados_para_cliente_v2_post_clientes_idcliente_cartoes(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Clientev2.POST_CLIENTES_IDCLIENTE_CARTOES), dataTable);
    }

    @Quando("executo Cliente - v2 - PostClientesIdclienteCartoes")
    public void executo_cliente_v2_post_clientes_idcliente_cartoes() {
        Clientev2.postClientesIdclienteCartoes.run();
    }

    @Entao("sistema processa Cliente - v2 - PostClientesIdclienteCartoes:")
    public void sistema_processa_cliente_v2_post_clientes_idcliente_cartoes(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES_IDCLIENTE_CARTOES)).getServiceResponse()
                , PostClientesIdclienteCartoesResponse_v2.class
        );
    }

    @Dado("efetuo Cliente - v2 - PostClientesIdclienteCartoes para {string}")
    public void efetuo_cliente_v2_post_clientes_idcliente_cartoes_para(String usuario) {
        List<UsuarioLoginEntity> usuarioLoginEntity = UsuariosLoginQuerie.getUsuarios(usuario);
        BuilderRequest.body.accept(Util.rota.apply(Clientev2.POST_CLIENTES_IDCLIENTE_CARTOES), null);
    }

    @Dado("que crio Cliente - v2 - PostClientesIdclienteCartoes {string}")
    public void que_crio_cliente_v2_post_clientes_idcliente_cartoes(String tipoCartao) {
        String entidadeComercial = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceResponse().getBody();
        String nomeTitular = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class).getNome();

        //CADASTRA CARTAO
        BuilderRequest.body.accept(Util.rota.apply(Clientev2.POST_CLIENTES_IDCLIENTE_CARTOES), ClienteCartao.valueOf(tipoCartao).pojo(Long.valueOf(entidadeComercial), nomeTitular));
        possuo_dados_para_cliente_v2_post_clientes_idcliente_cartoes(Map.of("idCliente", entidadeComercial));
        executo_cliente_v2_post_clientes_idcliente_cartoes();


        //BUSCA O HASH
        String idCartao = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES_IDCLIENTE_CARTOES)).getServiceResponse().getObjectBody(PostClientesIdclienteCartoesResponse_v2.class).getIdCartao().toString();
        new GetClientesCartao_v2Steps().possuo_dados_para_cliente_v2_get_clientes_cartao_param(Map.of("codigoCliente", entidadeComercial, "idCartao", idCartao));
        new GetClientesCartao_v2Steps().executo_cliente_v2_get_clientes_cartao();
    }

    @Dado("que possuo dados para Order - v1 - PostEcommerceOrders ClearSale {string}")
    public void que_possuo_dados_para_order_v1_post_ecommerce_orders_clear_sale(String canal) throws JsonProcessingException {
        String cpf = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class).getCpf();
        new GetPipClientesCpfCpf_v2Steps().que_efetuo_cliente_v2pip_get_clientes_cpf(cpf);
        GetClientePipClientesCpfResponse_v2 cliente = Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF)).getServiceResponse().getObjectBody(GetClientePipClientesCpfResponse_v2[].class)[0];
        GetClientesCartaoResponse_v2 cartao = Cache.chamadas.get(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO)).getServiceResponse().getObjectBody(GetClientesCartaoResponse_v2.class);

        PostEcommerceOrderRequest_v1 body = OrderGenerate.ORDER_SIMPLES.pojo();

        body.getClient().setCode(cliente.getCodEntidadeComercial());
        body.getPaymentMethods().get(0).setCardId(cartao.getIdCartao());
        body.getPaymentMethods().get(0).setCardHash(cartao.getHashCartao());
        body.getPaymentMethods().get(0).setCvv(null);

        body.setOrderSource(canal);

        BuilderRequest.body.accept(Util.rota.apply(OrderV1.POST_ECOMMERCE_ORDERS), body);
        OrderV1.postEcommerceOrders.run();
    }

    @Dado("que possuo dados para Order - v1 - PostEcommerceOrders ClearSale {string} e analise {string}")
    public void que_possuo_dados_para_order_v1_post_ecommerce_orders_clear_sale_e_analise(String canal, String analise) throws JsonProcessingException {
        String cpf = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class).getCpf();
        new GetPipClientesCpfCpf_v2Steps().que_efetuo_cliente_v2pip_get_clientes_cpf(cpf);
        GetClientePipClientesCpfResponse_v2 cliente = Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF)).getServiceResponse().getObjectBody(GetClientePipClientesCpfResponse_v2[].class)[0];
        PostEcommerceOrderRequest_v1 body = OrderGenerate.ORDER_SIMPLES.pojo();

        /*assumingThat(Cache.chamadas.get(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO)) != null, () -> {
            GetClientesCartaoResponse_v2 cartao = Cache.chamadas.get(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO)).getServiceResponse().getObjectBody(GetClientesCartaoResponse_v2.class);
            body.getClient().setCode(cliente.getCodEntidadeComercial());
            body.getPaymentMethods().get(0).setCardId(cartao.getIdCartao());
            body.getPaymentMethods().get(0).setCardHash(cartao.getHashCartao());
            body.getPaymentMethods().get(0).setCvv(null);
        });*/

        //APROVA 0 - 29
        //ANALISE 30 - 60
        //REPROVA 60 - 99
        //analise = "APROVADO";
        assumingThat(analise.equals("APROVADO"), () -> {
            body.getDelivery().get(0).setFeeValue(new BigDecimal("40.03"));
            body.getPaymentMethods().get(0).setValue(new BigDecimal("180.01"));
            body.setOrderTotalValue(new BigDecimal("180.01"));
        });
        assumingThat(analise.equals("PENDENTE"), () -> {
            body.getDelivery().get(0).setFeeValue(new BigDecimal("40.33"));
            body.getPaymentMethods().get(0).setValue(new BigDecimal("180.31"));
            body.setOrderTotalValue(new BigDecimal("180.31"));
        });
        assumingThat(analise.equals("REPROVA"), () -> {
            body.getDelivery().get(0).setFeeValue(new BigDecimal("40.86"));
            body.getPaymentMethods().get(0).setValue(new BigDecimal("180.84"));
            body.setOrderTotalValue(new BigDecimal("180.84"));
        });

        body.setOrderSource(canal);

        BuilderRequest.body.accept(Util.rota.apply(OrderV1.POST_ECOMMERCE_ORDERS), cartaoFluxo(body, cliente));
        OrderV1.postEcommerceOrders.run();
    }

    private PostEcommerceOrderRequest_v1 cartaoFluxo(PostEcommerceOrderRequest_v1 body, GetClientePipClientesCpfResponse_v2 cliente) {
        return Cache.chamadas.get(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO)) == null ?
                cartaoAberto(body, cliente) :
                cartaoCadastrado(body, cliente);
    }

    private PostEcommerceOrderRequest_v1 cartaoCadastrado(PostEcommerceOrderRequest_v1 body, GetClientePipClientesCpfResponse_v2 cliente) {
        GetClientesCartaoResponse_v2 cartao = Cache.chamadas.get(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO)).getServiceResponse().getObjectBody(GetClientesCartaoResponse_v2.class);
        body.getClient().setCode(cliente.getCodEntidadeComercial());
        body.getPaymentMethods().get(0).setCardId(cartao.getIdCartao());
        body.getPaymentMethods().get(0).setCardHash(cartao.getHashCartao());
        body.getPaymentMethods().get(0).setCvv("122");
        return body;
    }

    private PostEcommerceOrderRequest_v1 cartaoAberto(PostEcommerceOrderRequest_v1 body, GetClientePipClientesCpfResponse_v2 cliente) {
        body.getPaymentMethods().get(0).setCvv(Cache.faker.bothify("###"));
        body.getPaymentMethods().get(0).setCardNumber(Cartao.gerarSufixo("52", 16, "0"));
        body.getPaymentMethods().get(0).setExpirationDate("01/05/2024");
        body.getPaymentMethods().get(0).setCardHash(null);
        body.getPaymentMethods().get(0).setFirstHolder(Normalizer.normalize(cliente.getNome(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        body.getPaymentMethods().get(0).setCardId(null);
        body.getPaymentMethods().get(0).setCustomerCode(cliente.getCodEntidadeComercial());
        body.getPaymentMethods().get(0).setDocument(cliente.getCpf());
        return body;
    }
}
