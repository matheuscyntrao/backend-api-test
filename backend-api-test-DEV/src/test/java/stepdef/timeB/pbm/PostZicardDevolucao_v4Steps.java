package stepdef.timeB.pbm;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.PostZicardDevolucaoRequest_v4;
import model.timeB.pbm.request.PostZicardDevolucaoRequest_v4_Itens;
import model.timeB.pbm.response.PostZicardDevolucaoResponse_v4;
import service.timeB.pbm.Pbmv4;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class PostZicardDevolucao_v4Steps {

    public static String ROTA = Pbmv4.POST_ZICARD_DEVOLUCAO;

    @Dado("possuo dados para PbmService - v4 - PostZicardDevolucao:")
    public void possuo_dados_para_pbm_service_v4_post_zicard_devolucao(DataTable dataTable) throws JsonProcessingException {
        PostZicardDevolucaoRequest_v4 teste = CucumberUtils.getObjectBody(dataTable, PostZicardDevolucaoRequest_v4.class);
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, PostZicardDevolucaoRequest_v4.class));
    }

    @E("possuo dados para PbmService - v4 - PostZicardDevolucao itens:")
    public void possuo_dados_para_pbm_service_v4_post_zicard_devolucao_itens(DataTable dataTable) throws JsonProcessingException {
        PostZicardDevolucaoRequest_v4 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostZicardDevolucaoRequest_v4.class);
        body.setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostZicardDevolucaoRequest_v4_Itens[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo PbmService - v4 - PostZicardDevolucao")
    public void executo_pbm_service_v4_post_zicard_devolucao() {
        Pbmv4.postZicardDevolucao.run();
    }

    @Entao("sistema processa PbmService - v4 - PostZicardDevolucao:")
    public void sistema_processa_pbm_service_v4_post_zicard_devolucao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostZicardDevolucaoResponse_v4.class
        );
    }

    public void executeDevolucaoPbm(PostZicardDevolucaoRequest_v4 input) {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), input);
        executo_pbm_service_v4_post_zicard_devolucao();
    }
}
