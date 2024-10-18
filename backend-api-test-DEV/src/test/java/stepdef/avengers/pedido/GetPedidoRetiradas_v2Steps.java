package stepdef.avengers.pedido;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.pedido.response.GetPedidosRetirada_v2;
import service.avengers.pedido.Pedidov2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPedidoRetiradas_v2Steps {

    @Dado("possuo dados para Pedido - v2 - GetPedidoRetiradas path:")
    public void possuoDadosParaPedidoV2GetPedidoRetiradasPath(Map<String, String> arg1) throws JsonProcessingException {
        BuilderRequest.path.accept(Util.rota.apply(Pedidov2.GET_PEDIDOS_RETIRADAS), arg1);
    }

    @Quando("executo Pedido - v2 - GetPedidoRetiradas")
    public void executoPedidoV2GetPedidoRetiradas() {
        Pedidov2.getPedidosRetiradas.run();
    }

    @Entao("sistema processa Pedido - v2 - GetPedidoRetiradas:")
    public void sistemaProcessaPedidoV2GetPedidoRetiradas(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Pedidov2.POST_PEDIDOS_RETIRADAS)).getServiceResponse()
                , GetPedidosRetirada_v2.class
        );
    }

}
