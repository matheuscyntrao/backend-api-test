package stepdef.digital.pedidoEcommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.digital.PedidoEcommerceGenerate;
import enums.digital.pedidoEcommerce.PedidoGenerate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.response.GetClientePipClientesCpfResponse_v2;
import model.crossover.cliente.response.GetClientesCartaoResponse_v2;
import model.digital.pedidosEcommerce.request.*;
import service.crossover.cliente.Clientev2;
import service.crossover.cliente.Clientev2Pip;
import service.digital.pedidoEcommerce.PedidoEcommercev1;
import stepdef.crossover.cliente.GetPipClientesCpfCpf_v2Steps;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.Map;

public class PostPedidoSteps {
    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedido:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO), CucumberUtils.getObjectBody(dataTable, PostPedidoRequest_v1.class));
    }

    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedido cliente:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido_cliente(DataTable dataTable) throws JsonProcessingException {
        PostPedidoRequest_v1 input = Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().getObjectBody(PostPedidoRequest_v1.class);
        input.setCliente(CucumberUtils.getObjectBody(dataTable, PostPedidoRequest_v1_Cliente.class));
        Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().setBody(input);
    }

    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedido enderecoEntrega:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido_endereco_entrega(DataTable dataTable) throws JsonProcessingException {
        PostPedidoRequest_v1 input = Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().getObjectBody(PostPedidoRequest_v1.class);
        input.setEnderecoEntrega(CucumberUtils.getObjectBody(dataTable, PostPedidoRequest_v1_Endereco.class));
        Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().setBody(input);
    }

    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedido entrega:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido_entrega(DataTable dataTable) throws JsonProcessingException {
        PostPedidoRequest_v1 input = Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().getObjectBody(PostPedidoRequest_v1.class);
        input.setEntrega(CucumberUtils.getObjectBody(dataTable, PostPedidoRequest_v1_Entrega.class));
        Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().setBody(input);
    }

    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedido itens:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido_itens(DataTable dataTable) throws JsonProcessingException {
        PostPedidoRequest_v1 input = Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().getObjectBody(PostPedidoRequest_v1.class);
        input.setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostPedidoRequest_v1_Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().setBody(input);
    }

    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedido formaPagamentoCartoes:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido_forma_pagamento_cartoes(DataTable dataTable) throws JsonProcessingException {
        PostPedidoRequest_v1 input = Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().getObjectBody(PostPedidoRequest_v1.class);
        input.setFormaPagamentoCartoes(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostPedidoRequest_v1_FormaPagamentoCartoes[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceSpecs().setBody(input);
    }

    @Quando("executo PedidoEcommerce - v1 - PostPedido")
    public void executo_pedido_ecommerce_v1_post_pedido() {
        PedidoEcommercev1.postPedido.run();
    }

    @Entao("sistema processa PedidoEcommerce - v1 - PostPedido:")
    public void sistema_processa_pedido_ecommerce_v1_post_pedido(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO)).getServiceResponse()
                , String.class
        );
    }

    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedido Konduto {string}")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido_konduto(String origin) throws JsonProcessingException {
        String cpf = Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class).getCpf();
        new GetPipClientesCpfCpf_v2Steps().que_efetuo_cliente_v2pip_get_clientes_cpf(cpf);
        GetClientePipClientesCpfResponse_v2 cliente = Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF)).getServiceResponse().getObjectBody(GetClientePipClientesCpfResponse_v2[].class)[0];
        GetClientesCartaoResponse_v2 cartao = Cache.chamadas.get(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO)).getServiceResponse().getObjectBody(GetClientesCartaoResponse_v2.class);

        PostPedidoRequest_v1 body = PedidoEcommerceGenerate.CARTAO_MASTER.pojo();
        body.getCliente().setCodigoCliente(cliente.getCodEntidadeComercial());
        body.getCliente().setCpf(cpf);
        body.getCliente().setNome(cliente.getNome());

        body.getFormaPagamentoCartoes().get(0).setIdCartao(cartao.getIdCartao());
        body.getFormaPagamentoCartoes().get(0).setCodigoConvenio(cartao.getCodigoConvenio());

        body.setNumeroCarrinho(new PostPedidoCarrinhoSteps().gerarCarrinhoFromEntidadecomercial(body.getCliente().getCodigoCliente()));

        body.setOrigemPedido(origin.equals("APP") ? 5 : 3);

        BuilderRequest.body.accept(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO), body);
        PedidoEcommercev1.postPedido.run();
    }

    @Dado("possuo dados para PedidoEcommerce - v1 - PostPedido:")
    public void possuo_dados_para_pedido_ecommerce_v1_post_pedido(Map<String, String> dataTable) {
        PostPedidoRequest_v1 input = PedidoGenerate.valueOf(dataTable.get("TIPO_PEDIDO")).pojo();
        input.setClienteFromCadastro(Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceSpecs().getObjectBody(PostClienteRequest_v2.class));
        input.getCliente().setCodigoCliente(Long.parseLong(Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceResponse().getObjectBody(String.class)));
        input.setEntrega(null);  //TODO: Codar entrega/v3/entregas
        input.setEnderecoEntregaFromCliente(Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF)).getServiceResponse().getObjectBody(GetClientePipClientesCpfResponse_v2[].class)[0]);
        System.out.println("");
    }

}
