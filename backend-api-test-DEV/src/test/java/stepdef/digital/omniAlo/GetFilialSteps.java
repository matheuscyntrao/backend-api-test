package stepdef.digital.omniAlo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.omniAlo.response.GetFilialResponse_v1;
import service.digital.omniALo.OmniAlo_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetFilialSteps {
    @Dado("que possuo dados para OmniAlo - v1 - GetFilial path:")
    public void que_possuo_dados_para_omni_alo_v1_get_filial_path(Map<String,String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(OmniAlo_v1.GET_FILIAL), dataTable);
    }

    @Quando("executo OmniAlo - v1 - GetFilial")
    public void executo_omni_alo_v1_get_filial() {
        OmniAlo_v1.getFilial.run();
    }

    @Entao("sistema processa OmniAlo - v1 - GetFilial:")
    public void sistema_processa_omni_alo_v1_get_filial(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(OmniAlo_v1.GET_FILIAL)).getServiceResponse()
                , GetFilialResponse_v1.class
        );
    }
}
