package stepdef.avengers.pedido;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.pedido.response.PedidosFilialResponse_v2;
import service.avengers.pedido.Pedidov2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPedidosFilial_v2Steps {
    @Dado("^possuo dados para Pedido - v2 - GetPedidosFilial path:$")
    public void possuo_dados_para_Pedido_v2_GetPedidosFilial_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Pedidov2.GET_PEDIDOS_FILIAL), arg1);
    }

    @Dado("^possuo dados para Pedido - v2 - GetPedidosFilial param:$")
    public void possuo_dados_para_Pedido_v2_GetPedidosFilial_param(Map<String, String> arg1) throws Throwable {
        Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDOS_FILIAL)).getServiceSpecs().param.putAll(arg1);
    }

    @Quando("^executo Pedido - v2 - GetPedidosFilial$")
    public void executo_Pedido_v2_GetPedidosFilial() throws Throwable {
        Pedidov2.getPedidosFilial.run();
    }

    @Entao("^sistema processa Pedido - v2 - GetPedidosFilial:$")
    public void sistema_processa_Pedido_v2_GetPedidosFilial(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDOS_FILIAL)).getServiceResponse()
                , PedidosFilialResponse_v2[].class
        );
    }
}
