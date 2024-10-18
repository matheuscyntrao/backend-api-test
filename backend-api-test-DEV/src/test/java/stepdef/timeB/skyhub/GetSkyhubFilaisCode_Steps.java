package stepdef.timeB.skyhub;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.skyhub.response.Subsidiary;
import model.timeB.skyhub.response.Subsidiary_Stores;
import service.timeB.skyhub.Skyhub;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetSkyhubFilaisCode_Steps {

    @Dado("possuo dados para Skyhub - v1 - GetFiliaisCode path:")
    public void possuo_dados_para_skyhub_v1_get_filiais_code_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Skyhub.GET_FILIAIS_CODE), dataTable);
    }

    @Quando("executo Skyhub - v1 - GetFiliaisCode")
    public void executo_skyhub_v1_get_filiais_code() { Skyhub.getFiliaisCode.run(); }

    @Entao("sistema processa Skyhub - v1 - GetFiliaisCode:")
    public void sistema_processa_skyhub_v1_get_filiais_code(io.cucumber.datatable.DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                        , Cache.chamadas.get(Util.rota.apply(Skyhub.GET_FILIAIS_CODE)).getServiceResponse()
                        , Subsidiary.class
                );
        System.out.println(Skyhub.GET_FILIAIS_CODE);
    }

}
