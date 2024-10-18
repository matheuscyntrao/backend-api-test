package stepdef.digital.omniAlo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import service.digital.omniALo.OmniAlo_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPagamentoPosFilialSteps {

    @Dado("que possuo dados para OmniAlo - v1 - GetPagamentoPosFilial path:")
    public void que_possuo_dados_para_omni_alo_v1_get_pagamento_pos_filial_path(Map<String,String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(OmniAlo_v1.GET_PAGAMENTO_POS_FILIAL), dataTable);
    }

    @Quando("executo OmniAlo - v1 - GetPagamentoPosFilial")
    public void executo_omni_alo_v1_get_pagamento_pos_filial() {
        OmniAlo_v1.getPagamentoPosFilial.run();
    }

    @Entao("sistema processa OmniAlo - v1 - GetPagamentoPosFilial:")
    public void sistema_processa_omni_alo_v1_get_pagamento_pos_filial(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(OmniAlo_v1.GET_PAGAMENTO_POS_FILIAL)).getServiceResponse()
                , String.class
        );
    }
}
