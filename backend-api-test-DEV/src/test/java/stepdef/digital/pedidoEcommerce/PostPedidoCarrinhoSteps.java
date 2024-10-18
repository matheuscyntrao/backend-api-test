package stepdef.digital.pedidoEcommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.response.GetClientePipClientesCpfResponse_v2;
import model.digital.pedidosEcommerce.request.PostPedidoCarrinhoRequest_v1;
import model.digital.pedidosEcommerce.response.PostPedidoCarrinhoResponse_v1;
import service.crossover.cliente.Clientev2;
import service.crossover.cliente.Clientev2Pip;
import service.digital.pedidoEcommerce.PedidoEcommercev1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigInteger;

public class PostPedidoCarrinhoSteps {
    @Dado("que possuo dados para PedidoEcommerce - v1 - PostPedidoCarrinho:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_post_pedido_carrinho(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO_CARRINHO), CucumberUtils.getObjectBody(dataTable, PostPedidoCarrinhoRequest_v1.class));
    }

    @Quando("executo PedidoEcommerce - v1 - PostPedidoCarrinho")
    public void executo_pedido_ecommerce_v1_post_pedido_carrinho() {
        PedidoEcommercev1.postPedidoCarrinho.run();
    }

    @Entao("sistema processa PedidoEcommerce - v1 - PostPedidoCarrinho:")
    public void sistema_processa_pedido_ecommerce_v1_post_pedido_carrinho(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO_CARRINHO)).getServiceResponse()
                , PostPedidoCarrinhoResponse_v1.class
        );
    }

    @Dado("que efetuo PedidoEcommerce - v1 - PostPedidoCarrinho")
    public void que_efetuo_pedido_ecommerce_v1_post_pedido_carrinho() {
        Long codigoEntidadeComercial = Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF)).getServiceResponse().getObjectBody(GetClientePipClientesCpfResponse_v2[].class)[0].getCodEntidadeComercial();
        BuilderRequest.body.accept(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO_CARRINHO), PostPedidoCarrinhoRequest_v1.builder().codigoEntidadeComercial(codigoEntidadeComercial).build());
        executo_pedido_ecommerce_v1_post_pedido_carrinho();
    }

    @Dado("efetuo PedidoEcommerce - v1 - PostPedidoCarrinho cliente")
    public void efetuo_pedido_ecommerce_v1_post_pedido_carrinho() {
        Long codigoEntidadeComercial = Long.parseLong(Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceResponse().getObjectBody(String.class));
        BuilderRequest.body.accept(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO_CARRINHO), PostPedidoCarrinhoRequest_v1.builder().codigoEntidadeComercial(codigoEntidadeComercial).build());
        executo_pedido_ecommerce_v1_post_pedido_carrinho();
    }

    public Long gerarCarrinhoFromEntidadecomercial(Long entidadeComercial) {
        BuilderRequest.body.accept(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO_CARRINHO), PostPedidoCarrinhoRequest_v1.builder().codigoEntidadeComercial(entidadeComercial).build());
        PedidoEcommercev1.postPedidoCarrinho.run();
        return Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.POST_PEDIDO_CARRINHO)).getServiceResponse().getObjectBody(PostPedidoCarrinhoResponse_v1.class).getNumeroCarrinho();
    }
}
