package stepdef.timeB.pbm;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.PostCancelamentoRequest_v4;
import service.timeB.pbm.Pbmv4;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class PostEpharmaCancelamento_v4Steps {
    private static String ROTA = Pbmv4.POST_EPHARMA_CANCELAMENTO;

    @Dado("possuo dados para PbmService - v4 - PostEpharmaCancelamento:")
    public void possuo_dados_para_pbm_service_v4_post_epharma_cancelamento(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, PostCancelamentoRequest_v4.class));
    }

    @Quando("executo PbmService - v4 - PostEpharmaCancelamento")
    public void executo_pbm_service_v4_post_epharma_cancelamento() {
        Pbmv4.postEpharmaCancelamento.run();
    }

    @Entao("sistema processa PbmService - v4 - PostEpharmaCancelamento:")
    public void sistema_processa_pbm_service_v4_post_epharma_cancelamento(DataTable dataTable) throws Exception {
         ResponseValidator.validaResponse(dataTable
                         , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                         , String.class
                 );
    }
    public void executeCancelamentoFromPbm(PostCancelamentoRequest_v4 input) {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), input);
        executo_pbm_service_v4_post_epharma_cancelamento();
    }

}
