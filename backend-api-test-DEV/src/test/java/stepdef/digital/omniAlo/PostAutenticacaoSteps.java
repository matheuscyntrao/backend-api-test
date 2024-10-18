package stepdef.digital.omniAlo;

import com.fasterxml.jackson.core.JsonProcessingException;
import enums.PostAutenticacao;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.omniAlo.request.PostAutenticacaoRequest_V1;
import model.digital.omniAlo.response.PostAutenticacaoResponse_v1;
import service.digital.omniALo.OmniAlo_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class PostAutenticacaoSteps {

    @Dado("efetuo OmniAlo - v1 - PostAutenticacao {string}:")
    public void efetuo_omni_alo_v1_post_autenticacao(String cenario) {
        BuilderRequest.body.accept(Util.rota.apply(OmniAlo_v1.POST_AUTENTICACAO), PostAutenticacao.valueOf(cenario).pojo());
        OmniAlo_v1.postAutenticacao.run();
    }

    @Dado("que possuo dados para OmniAlo - v1 - PostAutenticacao:")
    public void que_possuo_dados_para_omni_alo_v1_post_autenticacao(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(OmniAlo_v1.POST_AUTENTICACAO), CucumberUtils.getObjectBody(dataTable, PostAutenticacaoRequest_V1.class));
    }

    @Quando("executo OmniAlo - v1 - PostAutenticacao")
    public void executo_omni_alo_v1_post_autenticacao() {
        OmniAlo_v1.postAutenticacao.run();
    }

    @Entao("sistema processa OmniAlo - v1 - PostAutenticacao:")
    public void sistema_processa_omni_alo_v1_post_autenticacao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(OmniAlo_v1.POST_AUTENTICACAO)).getServiceResponse()
                , PostAutenticacaoResponse_v1.class
        );
    }

    @Dado("efetuo OmniAlo - v1 - PostAutenticacao:")
    public void efetuo_omni_alo_v1_post_autenticacao(DataTable dataTable) throws JsonProcessingException {
        que_possuo_dados_para_omni_alo_v1_post_autenticacao(dataTable);
        executo_omni_alo_v1_post_autenticacao();
    }
}
