package stepdef.digital.omniAlo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.omniAlo.response.GetExtratoResponse_v1;
import service.digital.omniALo.OmniAlo_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetExtratoSteps {

    static final String ROTA = OmniAlo_v1.GET_EXTRATO;

    @Dado("que possuo dados para OmniAlo - v1 - GetExtrato path:")
    public void que_possuo_dados_para_omni_alo_v1_get_extrato_path(Map<String,String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA),(dataTable));
    }

    @Quando("executo OmniAlo - v1 - GetExtrato")
    public void executo_omni_alo_v1_get_extrato() {
        OmniAlo_v1.getExtrato.run();
    }

    @Entao("sistema processa OmniAlo - v1 - GetExtrato:")
    public void sistema_processa_omni_alo_v1_get_extrato(DataTable dataTable) throws Exception {
    ResponseValidator.validaResponse(dataTable,
            Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
            ,GetExtratoResponse_v1.class
        );
    }
}