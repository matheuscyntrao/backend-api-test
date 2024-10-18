package stepdef.crossover.cliente;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.response.GetClientesIdResponse_v1;
import service.crossover.cliente.Clientev1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetClientesId_v1Steps {
    @Dado("possuo dados para Cliente - v1 - GetClientesId path:")
    public void possuo_dados_para_cliente_v1_get_clientes_id_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Clientev1.GET_CLIENTES_ID), dataTable);
    }

    @E("possuo dados para Cliente - v1 - GetClientesId param:")
    public void possuo_dados_para_cliente_v1_get_clientes_id_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(Clientev1.GET_CLIENTES_ID), dataTable);
    }

    @Quando("executo Cliente - v1 - GetClientesId")
    public void executo_cliente_v1_get_clientes_id() {
        Clientev1.getClientesId.run();
    }

    @Entao("sistema processa Cliente - v1 - GetClientesId:")
    public void sistema_processa_cliente_v1_get_clientes_id(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Clientev1.GET_CLIENTES_ID)).getServiceResponse()
                , GetClientesIdResponse_v1.class
        );
    }
}
