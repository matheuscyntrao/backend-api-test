package stepdef.digital.omniAlo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.omniAlo.response.GetPagamentoPosResponse_v1;
import service.digital.omniALo.OmniAlo_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPagamentoPosSteps {

    @Dado("que possuo dados para OmniAlo - v1 - GetPagamentoPos path:")
    public void que_possuo_dados_para_omni_alo_v1_get_pagamento_pos_path(Map<String,String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(OmniAlo_v1.GET_PAGAMENTO_POS),dataTable);
    }

    @Quando("executo OmniAlo - v1 - GetPagamentoPos")
    public void executo_omni_alo_v1_get_pagamento_pos() {
        OmniAlo_v1.getFormaPagamentoPos.run();
    }

    @Entao("sistema processa OmniAlo - v1 - GetPagamentoPos:")
    public void sistema_processa_omni_alo_v1_get_pagamento_pos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(OmniAlo_v1.GET_PAGAMENTO_POS)).getServiceResponse()
                , GetPagamentoPosResponse_v1.class
        );
    }
}
