package stepdef.timeB.pbmGatewayService;

import entity.timeb.pbmGateway.PbmItensPreAutorizacaoEntity;
import entity.timeb.pbmGateway.PbmPreAutorizacoesOmniEntity;
import entity.timeb.pbmGateway.PbmTransacoesOmniEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;
import queries.timeB.pbm.PbmTransacoesOmni;
import service.timeB.pbmGatewayService.PbmGatewayService;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostCancelamento_v1Steps {

    private static String ROTA = PbmGatewayService.POST_CANCELAMENTO;

    @Dado("possuo dados para PbmGatewayService - v1 - PostCancelamento path:")
    public void possuo_dados_para_pbm_gateway_service_v1_post_cancelamento_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo PbmGatewayService - v1 - PostCancelamento")
    public void executo_pbm_gateway_service_v1_post_cancelamento() {
        PbmGatewayService.postCancelamento.run();
    }

    @Entao("sistema processa PbmGatewayService - v1 - PostCancelamento:")
    public void sistema_processa_pbm_gateway_service_v1_post_cancelamento(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , String.class
        );
    }

    public void executeCancelamentoFromPbm(String identificador) {
        possuo_dados_para_pbm_gateway_service_v1_post_cancelamento_path(Map.of("identificadorTransacao", identificador));
        executo_pbm_gateway_service_v1_post_cancelamento();
    }


    @Entao("valido PbmGatewayService - v1 - Tabela de pbm_cancelamentos_omni")
    public void valido_pbm_gateway_service_v1_tabela_de_pbm_cancelamentos_omni() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 204, () -> {
            PbmPreAutorizacoesOmniEntity cancelamentoPbm = PbmTransacoesOmni.getCancelamentoOmni(getIdentificadorAutorizacao());
            assertAll(
                    () -> assertEquals(cancelamentoPbm.getOrigem(), "pbm_gateway_service")
            );
        });
    }
    @E("efetuo o cancelamento do PBM")
    public void efetuo_o_cancelamento_do_pbm_na_versao_de_um_preAutorizacao() {
        String identificador = getIdentificadorAutorizacao();
        new PostCancelamento_v1Steps().executeCancelamentoFromPbm(identificador);
    }
    public String getIdentificadorAutorizacao() {
        AtomicReference<String> indenticadortransacao = new AtomicReference<>();
        indenticadortransacao.set(Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).
                getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class).
                getTransactionIdentify());
        return indenticadortransacao.get();
    }
}
