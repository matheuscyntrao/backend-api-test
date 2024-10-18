package stepdef.digital.pedidoEcommerce;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.pedidosEcommerce.response.GetPedidosIdentificadorclienteHistoricoResponse_v1;
import service.digital.pedidoEcommerce.PedidoEcommercev1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPedidoIdentificadorclienteHistoricoSteps {
    @Dado("que possuo dados para PedidoEcommerce - v1 - GetPedidoIdentificadorclienteHistorico:")
    public void que_possuo_dados_para_pedido_ecommerce_v1_get_pedido_identificadorcliente_historico(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(PedidoEcommercev1.GET_PEDIDOS_IDENTIFICADORCLIENTE_HISTORICO), dataTable);
    }

    @Quando("executo PedidoEcommerce - v1 - GetPedidoIdentificadorclienteHistorico")
    public void executo_pedido_ecommerce_v1_get_pedido_identificadorcliente_historico() {
        PedidoEcommercev1.getPedidosIdentificadorclienteHistorico.run();
    }

    @Entao("sistema processa PedidoEcommerce - v1 - GetPedidoIdentificadorclienteHistorico:")
    public void sistema_processa_pedido_ecommerce_v1_get_pedido_identificadorcliente_historico(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(PedidoEcommercev1.GET_PEDIDOS_IDENTIFICADORCLIENTE_HISTORICO)).getServiceResponse()
                , GetPedidosIdentificadorclienteHistoricoResponse_v1.class
        );
    }
}
