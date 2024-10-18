package stepdef.avengers.pedido;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.pedido.response.PedidosHistoricoResponse_v2;
import service.avengers.pedido.Pedidov2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPedidosHistorico_v2Steps {
    @Dado("^possuo dados para Pedido - v2 - GetPedidosHistorico path:$")
    public void possuo_dados_para_Pedido_v2_GetPedidosHistorico_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Pedidov2.GET_PEDIDOS_CPF_HISTORICO), arg1);
    }

    @Quando("^executo Pedido - v2 - GetPedidosHistorico$")
    public void executo_Pedido_v2_GetPedidosHistorico() throws Throwable {
        Pedidov2.getPedidosCpfHistorico.run();
    }

    @Entao("^sistema processa Pedido - v2 - GetPedidosHistorico:$")
    public void sistema_processa_Pedido_v2_GetPedidosHistorico(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDOS_CPF_HISTORICO)).getServiceResponse()
                , PedidosHistoricoResponse_v2[].class
        );
    }

}
