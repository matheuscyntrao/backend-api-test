package stepdef.timeB.pbm;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.*;
import model.timeB.pbm.response.PostZicardPreAutorizacaoResponse_v4;
import service.timeB.pbm.Pbmv4;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class PostZicardPreAutorizacao_v4Steps {

    private static String ROTA = Pbmv4.POST_ZICARD_PREAUTORIZACAO;

    @Dado("possuo dados para PbmService - v4 - PostZicardPreAutorizacao:")
    public void possuo_dados_para_pbm_service_v4_post_zicard_pre_autorizacao(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4.class));
    }

    @E("possuo dados para PbmService - v4 - PostZicardPreAutorizacao item:")
    public void possuo_dados_para_pbm_service_v4_post_zicard_pre_autorizacao_item(DataTable dataTable) throws JsonProcessingException {
        PostPreAutorizacaoRequest_v4 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v4.class);
        body.setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4_Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @E("possuo dados para PbmService - v4 - PostZicardPreAutorizacao item receita:")
    public void possuo_dados_para_pbm_service_v4_post_zicard_pre_autorizacao_item_receita(DataTable dataTable) throws JsonProcessingException {
        PostPreAutorizacaoRequest_v4 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v4.class);
        body.getItens().get(0).setReceita(CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4_Item_Receita.class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo PbmService - v4 - PostZicardPreAutorizacao")
    public void executo_pbm_service_v4_post_zicard_pre_autorizacao() {
        Pbmv4.postZicardPreAutorizacao.run();
    }

    @Entao("sistema processa PbmService - v4 - PostZicardPreAutorizacao:")
    public void sistema_processa_pbm_service_v4_post_zicard_pre_autorizacao(DataTable dataTable) throws Exception {
        PostZicardPreAutorizacaoResponse_v4 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostZicardPreAutorizacaoResponse_v4.class);
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostZicardPreAutorizacaoResponse_v4.class
        );
    }
}
