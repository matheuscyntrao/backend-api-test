package stepdef.digital.omniAlo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.omniAlo.response.GetFidelidadeResponse_v1;
import service.digital.omniALo.OmniAlo_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetFidelidadeSteps {

    static final String ROTA = OmniAlo_v1.GET_FIDELIDADE;

    @Dado("que possuo dados para OmniAlo - v1 - GetFidelidade path:")
    public void que_possuo_dados_para_omni_alo_v1_get_fidelidade_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Dado("que possuo dados para OmniAlo - v1 - GetFidelidade param:")
    public void que_possuo_dados_para_omni_alo_v1_get_fidelidade_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo OmniAlo - v1 - GetFidelidade")
    public void executo_omni_alo_v1_get_fidelidade() {
        OmniAlo_v1.getFidelidade.run();
    }

    @Entao("sistema processa OmniAlo - v1 - GetFidelidade:")
    public void sistema_processa_omni_alo_v1_get_fidelidade(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetFidelidadeResponse_v1.class
        );
    }
}
