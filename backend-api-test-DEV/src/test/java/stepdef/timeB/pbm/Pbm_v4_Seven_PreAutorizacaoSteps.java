package stepdef.timeB.pbm;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4_Item;
import model.timeB.pbm.response.PreAutorizacaoResponse_v4;
import service.timeB.pbm.Pbmv4;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class Pbm_v4_Seven_PreAutorizacaoSteps {
    @Dado("possuo dados para Pbm - v4 - SevenPreAutorizacao:")
    public void possuo_dados_para_pbm_v4_seven_pre_autorizacao(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Pbmv4.POST_SEVEN_PRE_AUTORIZACAO), CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4.class));
    }

    @Dado("possuo dados para Pbm - v4 - SevenPreAutorizacao itens:")
    public void possuo_dados_para_pbm_v4_seven_pre_autorizacao_itens(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        PostPreAutorizacaoRequest_v4 input = Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_SEVEN_PRE_AUTORIZACAO)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v4.class);
        input.setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v4_Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_SEVEN_PRE_AUTORIZACAO)).getServiceSpecs().setBody(input);
    }

    @Quando("executo Pbm - v4 - SevenPreAutorizacao")
    public void executo_pbm_v4_seven_pre_autorizacao() {
        Pbmv4.postSevenPreAutorizacao.run();
    }

    @Entao("sistema processa Pbm - v4 - SevenPreAutorizacao:")
    public void sistema_processa_pbm_v4_seven_pre_autorizacao(io.cucumber.datatable.DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_SEVEN_PRE_AUTORIZACAO)).getServiceResponse()
                , PreAutorizacaoResponse_v4.class
        );
    }
}
