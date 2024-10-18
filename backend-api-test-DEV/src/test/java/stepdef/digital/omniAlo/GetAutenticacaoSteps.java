package stepdef.digital.omniAlo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.omniAlo.response.PostAutenticacaoResponse_v1;
import service.digital.omniALo.OmniAlo_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetAutenticacaoSteps {
    @Dado("que possuo dados para OmniAlo - v1 - GetAutenticacao header:")
    public void que_possuo_dados_para_omni_alo_v1_get_autenticacao_header(Map<String, String> dataTable) {
        BuilderRequest.header.accept(Util.rota.apply(OmniAlo_v1.GET_AUTENTICACAO), dataTable);
    }

    @Quando("executo OmniAlo - v1 - GetAutenticacao")
    public void executo_omni_alo_v1_get_autenticacao() {
        OmniAlo_v1.getAutenticacao.run();
    }

    @Entao("sistema processa OmniAlo - v1 - GetAutenticacao:")
    public void sistema_processa_omni_alo_v1_get_autenticacao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(OmniAlo_v1.GET_AUTENTICACAO)).getServiceResponse()
                , String.class
        );
    }

    @Quando("efetuo OmniAlo - v1 - GetAutenticacao")
    public void efetuo_omni_alo_v1_get_autenticacao() {
        que_possuo_dados_para_omni_alo_v1_get_autenticacao_header(Map.of("token",
        Cache.chamadas.get(Util.rota.apply(OmniAlo_v1.POST_AUTENTICACAO)).getServiceResponse().getObjectBody(PostAutenticacaoResponse_v1.class).getAccessToken()
                ));
        executo_omni_alo_v1_get_autenticacao();
    }
}
