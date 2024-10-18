package stepdef.timeB.pbm;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.*;
import model.timeB.pbm.response.PostEpharmaPreAutorizacaoResponse_v4;
import service.timeB.pbm.Pbmv4;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class PostEpharmaPreAutorizacao_v4Steps {

    private static String ROTA = Pbmv4.POST_EPHARMA_PRE_AUTORIZACAO;

    @Dado("possuo dados para PbmService - v4 - PostEpharmaPreAutorizacao:")
    public void possuo_dados_para_pbm_service_v4_post_epharma_pre_autorizacao(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4.class));
    }

    @Dado("possuo dados para PbmService - v4 - PostEpharmaPreAutorizacao item:")
    public void possuo_dados_para_pbm_service_v4_post_epharma_pre_autorizacao_item(DataTable dataTable) throws JsonProcessingException {
        PostPreAutorizacaoRequest_v4 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v4.class);
        body.setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4_Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Dado("possuo dados para PbmService - v4 - PostEpharmaPreAutorizacao receita:")
    public void possuo_dados_para_pbm_service_v4_post_epharma_pre_autorizacao_receita(DataTable dataTable) throws JsonProcessingException {
        PostPreAutorizacaoRequest_v4 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v4.class);
        body.getItens().get(0).setReceita(CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4_Item_Receita.class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo PbmService - v4 - PostEpharmaPreAutorizacao")
    public void executo_pbm_service_v4_post_epharma_pre_autorizacao() {
        Pbmv4.postEpharmaPreAutorizacao.run();
    }

    @Entao("sistema processa PbmService - v4 - PostEpharmaPreAutorizacao:")
    public void sistema_processa_pbm_service_v4_post_epharma_pre_autorizacao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostEpharmaPreAutorizacaoResponse_v4.class
        );
    }
}
