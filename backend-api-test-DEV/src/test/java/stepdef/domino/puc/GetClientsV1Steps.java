package stepdef.domino.puc;

import enums.domino.puc.PucClients;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.pucservice.response.GetClientsResponse_v1;
import service.domino.puc.Pucv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class GetClientsV1Steps {
    private static String ROTA = Pucv1.GET_CLIENTS;

    @Dado("possuo dados para clients - v1 - GetClients {string}")
    public void possuo_dados_para_clients_v1_get_clients(String fluxoPuc) {
        BuilderRequest.param.accept(Util.rota.apply((ROTA)), PucClients.valueOf(fluxoPuc).pojo());
    }

    @Quando("executo GetClients - v1 - GetClients")
    public void executo_get_clients_v1_get_clients() {
        Pucv1.getClients.run();
    }

    @Entao("sistema processa GetClients - v1 - GetClients:")
    public void sistema_processa_get_clients_v1_get_clients(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetClientsResponse_v1[].class);
    }
}
