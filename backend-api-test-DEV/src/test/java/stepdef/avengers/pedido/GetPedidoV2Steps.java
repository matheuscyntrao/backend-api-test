package stepdef.avengers.pedido;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.pedido.response.PedidosPedidoResponse_v2;
import service.avengers.pedido.Pedidov2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPedidoV2Steps {
    @Dado("^possuo dados para Pedido - v2 - GetPedido path:$")
    public void possuo_dados_para_Pedido_v2_GetPedido_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Pedidov2.GET_PEDIDO), arg1);
    }

    @Quando("^executo Pedido - v2 - GetPedido$")
    public void executo_Pedido_v2_GetPedido() throws Throwable {
        Pedidov2.getPedido.run();
    }

    @Entao("^sistema processa Pedido - v2 - GetPedido:$")
    public void sistema_processa_Pedido_v2_GetPedido(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDO)).getServiceResponse()
                , PedidosPedidoResponse_v2.class
        );
    }

    public Long getCarrinho(Long pedido) throws Throwable {
        possuo_dados_para_Pedido_v2_GetPedido_path(Map.of("pedido", pedido.toString()));
        Pedidov2.getPedido.run();
        return Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDO)).getServiceResponse().getObjectBody(PedidosPedidoResponse_v2.class).getNumeroCarrinho();
    }
}
