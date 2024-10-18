package stepdef.timeB.pbmGatewayService;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.timeb.pbmGateway.PbmItensPreAutorizacaoEntity;
import entity.timeb.pbmGateway.PbmPreAutorizacoesOmniEntity;
import entity.timeb.pbmGateway.PbmTransacoesOmniEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1_ItemPreAuthorization;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1_ItemPreAuthorization_Prescription;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import queries.timeB.pbm.PbmTransacoesOmni;
import service.timeB.pbmGatewayService.PbmGatewayService;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostPreAutorizacao_v1Steps {

    private static String ROTA = PbmGatewayService.POST_PRE_AUTORIZACAO;

    @Dado("possuo dados para PbmGatewayService - v1 - PostPreAutorizacao:")
    public void possuo_dados_para_pbm_gateway_service_v1_post_pre_autorizacao(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v1.class));
    }

    @E("possuo dados para PbmGatewayService - v1 - PostPreAutorizacao itemPreAuthorization:")
    public void possuo_dados_para_pbm_gateway_service_v1_post_pre_autorizacao_item_Pre_Authorization(DataTable dataTable) throws JsonProcessingException {
        PostPreAutorizacaoRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v1.class);
        body.setItemPreAuthorization(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v1_ItemPreAuthorization[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @E("possuo dados para PbmGatewayService - v1 - PostPreAutorizacao itemRequest prescription:")
    public void possuo_dados_para_pbm_gateway_service_v1_post_pre_autorizacao_item_request_prescription(DataTable dataTable) throws JsonProcessingException {
        PostPreAutorizacaoRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v1.class);
        body.getItemPreAuthorization().get(0).setPrescription(CucumberUtils.getObjectBody(dataTable, PostPreAutorizacaoRequest_v1_ItemPreAuthorization_Prescription.class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo PbmGatewayService - v1 - PostPreAutorizacao")
    public void executo_pbm_gateway_service_v1_post_pre_autorizacao() {
        PbmGatewayService.PostPreAutorizacao.run();
    }

    @Entao("sistema processa PbmGatewayService - v1 - PostPreAutorizacao:")
    public void sistema_processa_pbm_gateway_service_v1_post_pre_autorizacao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostPreAutorizacaoResponse_v1.class
        );
    }

    @Entao("valido PbmGatewayService - v1 - Tabela de pbm_Transacoes_Omni")
    public void valido_pbm_gateway_service_v1_tabela_de_pbm_transacoes_omni() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 201, () -> {
            PostPreAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class);
            PostPreAutorizacaoRequest_v1 request = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v1.class);
            PbmTransacoesOmniEntity transacoes = PbmTransacoesOmni.getTransacoesOmni(response.getTransactionIdentify());
            assertAll(
                    () -> assertEquals(transacoes.getTransactionIdentify(), response.getTransactionIdentify()),
                    () -> assertEquals(transacoes.getCodigoAdminConvenios(), response.getCodeAdminCovenant()),
                    () -> assertEquals(transacoes.getUsuarioTransacao(), request.getUser()),
                    () -> assertEquals(transacoes.getTipoPrograma(), request.getTypeProgram()),
                    () -> assertEquals(StringUtils.leftPad(transacoes.getCpfBeneficiario(), 11, "0"), request.getCpfBeneficiary()),
                    () -> assertEquals(transacoes.getCodigoCanalVenda(), request.getChannel()),
                    () -> assertEquals(StringUtils.leftPad(transacoes.getCpfAtendimento(), 11, "0"), request.getCpfAttendance()),
                    () -> assertEquals(transacoes.getOrigem(), "pbm_gateway_service")
            );
        });
    }

    @Entao("valido PbmGatewayService - v1 - Tabela de pbm_pre_autorizacoes_omni")
    public void valido_pbm_gateway_service_v1_tabela_de_pbm_pre_transacoes_omni() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 201, () -> {
            PostPreAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class);
            PbmPreAutorizacoesOmniEntity autorizacoes = PbmTransacoesOmni.getPreAutorizacoesOmni(response.getTransactionIdentify());
            assertAll(
                    () -> assertEquals(autorizacoes.getTransactionIdentify(), response.getTransactionIdentify()),
                    () -> assertEquals(autorizacoes.getNsuPreAuthorization(), response.getNsuPreAuthorization()),
                    () -> assertEquals(autorizacoes.getOrigem(), "pbm_gateway_service")
            );
        });
    }

    @Entao("valido PbmGatewayService - v1 - Tabela de pbm_itens_pre_autorizacao_omni")
    public void valido_pbm_gateway_service_v1_tabela_de_pbm_itens_pre_transacao_omni() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode().toString().contains("20"), () -> {
            PostPreAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class);
            PbmItensPreAutorizacaoEntity itensAutorizados = PbmTransacoesOmni.getItensPreAutorizacao(response.getTransactionIdentify());
            assertAll(
                    () -> assertEquals(itensAutorizados.getTransactionIdentify(), response.getTransactionIdentify()),
                    () -> assertEquals(itensAutorizados.getCodeItem(), response.getItemsApproved().get(0).getPanvelItem()),
                    () -> assertEquals(itensAutorizados.getEan(), response.getItemsApproved().get(0).getEan()),
                    () -> assertEquals(itensAutorizados.getQuantityPreAuthorization(), response.getItemsApproved().get(0).getQuantityPreAuthorization()),
                    () -> assertEquals(itensAutorizados.getPriceNetPreAuthorized().setScale(2, RoundingMode.UP), response.getItemsApproved().get(0).getPriceNetPreAuthorized().setScale(2, RoundingMode.UP))
            );
        });
    }

    @Entao("valido o melhor preco")
    public void valido_o_melhor_preco() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 201, () -> {
            PostPreAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class);
            PostPreAutorizacaoRequest_v1 request = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v1.class);
            assumingThat(request.getItemPreAuthorization().get(0).getPriceNet().compareTo(response.getItemsApproved().get(0).getPriceNetPreAuthorized()) != -1, () -> {
                assertAll(
                        () -> Assert.assertFalse(response.getItemsApproved().get(0).getBestPricePanvel())
                );
            });
            assumingThat(request.getItemPreAuthorization().get(0).getPriceNet().compareTo(response.getItemsApproved().get(0).getPriceNetPreAuthorized()) == -1, () -> {
                assertAll(
                        () -> Assert.assertTrue(response.getItemsApproved().get(0).getBestPricePanvel())
                );
            });
        });
    }
}