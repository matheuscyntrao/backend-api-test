package stepdef.domino.filial;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.filial.response.GetFilialIdResponse_v1;
import service.domino.filial.Filialv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.Map;

public class GetFiliaisFilial_v1Steps {
    @Dado("possuo dados para Filial - v1 - GetFiliaisFilial path:")
    public void possuo_dados_para_filial_v1_get_filiais_filial_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Filialv1.GET_FILIAIS_FILIAL), dataTable);
    }

    @Quando("executo Filial - v1 - GetFiliaisFilial")
    public void executo_filial_v1_get_filiais_filial() {
        Filialv1.getFiliaisFilial.run();
    }

    @Entao("sistema processa Filial - v1 - GetFiliaisFilial:")
    public void sistema_processa_filial_v1_get_filiais_filial(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Filialv1.GET_FILIAIS_FILIAL)).getServiceResponse()
                , GetFilialIdResponse_v1.class
        );
    }

    public void runGetFilial(Integer filial) {
        Map<String, String> path = new HashMap<>();
        path.put("filial", filial.toString());
        possuo_dados_para_filial_v1_get_filiais_filial_path(path);
        executo_filial_v1_get_filiais_filial();
    }
}
