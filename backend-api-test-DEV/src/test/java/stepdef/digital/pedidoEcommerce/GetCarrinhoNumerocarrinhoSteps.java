package stepdef.digital.pedidoEcommerce;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import service.digital.pedidoEcommerce.PedidoEcommercev1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetCarrinhoNumerocarrinhoSteps {
    @Dado("que possuo dados para PedidoEcommerce - v1 - GetCarrinhoNumerocarrinho path:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_get_carrinho_numerocarrinho_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(PedidoEcommercev1.GET_PEDIDO_CARRINHO_NUMEROCARRINHO), dataTable);
    }

    @Quando("executo PedidoEcommerce - v1 - GetCarrinhoNumerocarrinho")
    public void executo_pedido_ecommerce_v1_get_carrinho_numerocarrinho() {
        PedidoEcommercev1.getPedidoCarrinhoNumerocarrinho.run();
    }

    @Entao("sistema processa PedidoEcommerce - v1 - GetCarrinhoNumerocarrinho:")
    public void sistema_processa_pedido_ecommerce_v1_get_carrinho_numerocarrinho(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.GET_PEDIDO_CARRINHO_NUMEROCARRINHO)).getServiceResponse()
                , String.class
        );
    }
}
