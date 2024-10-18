package stepdef.timeB.pbm;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.*;
import model.timeB.pbm.response.PostZicardConfirmacaoResponse_v5;
import service.timeB.pbm.Pbmv5;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class PostZicardConfirmacao_v5Steps {

    private static String ROTA = Pbmv5.POST_ZICARD_CONFIRMACAO;

    @Dado("possuo dados para PbmService - v5 - PostZicardConfirmacao:")
    public void possuo_dados_para_pbm_service_v5_post_zicard_confirmacao(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, PostZicardConfirmacaoRequest_v5.class));
    }

    @E("possuo dados para PbmService - v5 - PostZicardConfirmacao autorizacoes:")
    public void possuo_dados_para_pbm_service_v5_post_zicard_confirmacao_autorizacoes(DataTable dataTable) throws JsonProcessingException {
        PostZicardConfirmacaoRequest_v5 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostZicardConfirmacaoRequest_v5.class);
        body.setAutorizacoes(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostZicardConfirmacaoRequest_v5_Autorizacoes[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @E("possuo dados para PbmService - v5 - PostZicardConfirmacao autorizacoes itens:")
    public void possuo_dados_para_pbm_service_v5_post_zicard_confirmacao_autorizacoes_itens(DataTable dataTable) throws JsonProcessingException {
        PostZicardConfirmacaoRequest_v5 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostZicardConfirmacaoRequest_v5.class);
        body.getAutorizacoes().get(0).setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostZicardConfirmacaoRequest_v5_Autorizacoes_Itens[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo PbmService - v5 - PostZicardConfirmacao")
    public void executo_pbm_service_v5_post_zicard_confirmacao() {
        Pbmv5.postZicardConfirmacao.run();
    }

    @Entao("sistema processa PbmService - v5 - PostZicardConfirmacao:")
    public void sistema_processa_pbm_service_v5_post_zicard_confirmacao(DataTable dataTable) throws Exception {
        PostZicardConfirmacaoRequest_v5 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostZicardConfirmacaoRequest_v5.class);
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostZicardConfirmacaoResponse_v5.class
        );
    }

    public void executeConfirmacaoPbm(PostZicardConfirmacaoRequest_v5 input) {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), input);
        executo_pbm_service_v5_post_zicard_confirmacao();
    }
}
