package stepdef.timeB.E2E;

import com.fasterxml.jackson.core.JsonProcessingException;
import enums.*;
import enums.time_b.pbm.PbmEnum;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.PostAutorizacaoRequest_v4;
import model.timeB.pbm.request.PostCancelamentoRequest_v4;
import model.timeB.pbm.response.PostEpharmaPreAutorizacaoResponse_v4;
import model.timeB.pbm.response.PostFuncionalPreAutorizacaoResponse_v4;
import model.timeB.pbm.response.PostZicardPreAutorizacaoResponse_v4;
import model.timeB.pbm.response.PreAutorizacaoResponse_v4;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1_deviationFlux_formAccess_fields;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1_deviationFlux_transactionControl;
import org.testng.Assert;
import service.crossover.cliente.Clientev2Pip;
import service.timeB.pbm.Pbmv4;
import service.timeB.pbmGatewayService.PbmGatewayService;
import stepdef.timeB.pbm.*;
import stepdef.timeB.pbmGatewayService.PostAutorizacao_v1Steps;
import stepdef.timeB.pbmGatewayService.PostCancelamento_v1Steps;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class E2EPbmSteps {
    @Dado("que efetuo preAutorizacao do PBM {string} na versao {string}")
    public void que_efetuo_pre_autorizacao_do_pbm_na_versao(String tipoPbm, String versaoPbmPre) {
        Cache.valores.put(Util.rota.apply("TIPO_PBM"), tipoPbm);
        AtomicReference<Boolean> executou = new AtomicReference<>(false);
        assumingThat(tipoPbm.contains("FUNCIONAL") && versaoPbmPre.equals("PBM"), () -> {
            BuilderRequest.body.accept(Util.rota.apply(Pbmv4.POST_FUNCIONAL_PRE_AUTORIZACAO), PbmFuncionalPreAutorizacaoGenerate.AUTORIZACAO_VALIDA.pojo());
            Pbmv4.postFuncionalPreAutorizacao.run();
            executou.set(true);
        });
        assumingThat(tipoPbm.contains("ZICARD") && versaoPbmPre.equals("PBM"), () -> {
            BuilderRequest.body.accept(Util.rota.apply(Pbmv4.POST_ZICARD_PREAUTORIZACAO), PbmZicardPreAutorizacaoGenerate.AUTORIZACAO_VALIDA.pojo());
            Pbmv4.postZicardPreAutorizacao.run();
            executou.set(true);
        });
        assumingThat(tipoPbm.contains("EPHARMA") && versaoPbmPre.equals("PBM"), () -> {
            BuilderRequest.body.accept(Util.rota.apply(Pbmv4.POST_EPHARMA_PRE_AUTORIZACAO), PbmEpharmaPreAutorizacaoGenerate.AUTORIZACAO_VALIDA.pojo());
            Pbmv4.postEpharmaPreAutorizacao.run();
            executou.set(true);
        });
        assumingThat(tipoPbm.contains("SEVEN") && versaoPbmPre.equals("PBM"), () -> {
            BuilderRequest.body.accept(Util.rota.apply(Pbmv4.POST_SEVEN_PRE_AUTORIZACAO), PbmSevenPreAutorizacaoGenerate.AUTORIZACAO_VALIDA.pojo());
            Pbmv4.postSevenPreAutorizacao.run();
            executou.set(true);
        });
        assumingThat(versaoPbmPre.equals("PBM_GATEWAY"), () -> {
            BuilderRequest.body.accept(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO), PbmGatewayPreAutorizacaoGenerate.valueOf(Cache.valores.get(Util.rota.apply("TIPO_PBM"))).pojo(null));
            PbmGatewayService.PostPreAutorizacao.run();
            executou.set(true);
        });
        assumingThat(!executou.get(), () -> {
            throw new io.cucumber.java.PendingException("Cenario não codado");
        });
    }

    @Dado("valido preAutorizacao do PBM {string} na versao {string}")
    public void valido_pre_autorizacao_do_pbm_na_versao(String tipoPbm, String versaoPbmPre) {
        assumingThat(versaoPbmPre.equals("PBM_GATEWAY"), () -> {
            PostPreAutorizacaoRequest_v1 request = Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).getServiceSpecs().getObjectBody(PostPreAutorizacaoRequest_v1.class);
            PostPreAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class);

            BigDecimal priceGrossRequest = request.getItemPreAuthorization().get(0).getPriceGross();
            BigDecimal priceNetRequest = request.getItemPreAuthorization().get(0).getPriceNet();

            BigDecimal priceNetPreAuthorized = response.getItemsApproved().get(0).getPriceNetPreAuthorized();
            Double percentageDiscountPreAuthorized = response.getItemsApproved().get(0).getPercentageDiscountPreAuthorized();
            BigDecimal valueDiscountPreAuthorized = response.getItemsApproved().get(0).getValueDiscountPreAuthorized();

            DecimalFormat df = new DecimalFormat("0.00");

            BigDecimal desconto = priceNetPreAuthorized.doubleValue() > priceGrossRequest.doubleValue() ? BigDecimal.valueOf(0) : priceGrossRequest.subtract(priceNetPreAuthorized);
            Double percentual = (desconto.doubleValue() / priceGrossRequest.doubleValue()) * 100;


            System.out.println("-----> desconto " + desconto + "  -----> " + valueDiscountPreAuthorized);
            System.out.println("-----> percentual " + df.format(percentual) + "  -----> " + df.format(percentageDiscountPreAuthorized));

            assertAll(
                    () -> assertEquals(df.format(desconto), df.format(valueDiscountPreAuthorized)),
                    () -> assertEquals(df.format(percentual), df.format(percentageDiscountPreAuthorized))
            );
        });
    }

    @Dado("que efetuo preAutorizacao do PBM {string} para adesao")
    public void que_efetuo_pre_autorizacao_do_pbm_para_adesao(String tipoPbm) {
        Cache.valores.put(Util.rota.apply("TIPO_PBM"), tipoPbm);
        BuilderRequest.body.accept(Util.rota.apply((PbmGatewayService.POST_PRE_AUTORIZACAO)), PbmGatewayPreAutorizacaoGenerate.valueOf(Cache.valores.get(Util.rota.apply("TIPO_PBM"))).pojo(null));
        PbmGatewayService.PostPreAutorizacao.run();
    }

    @Dado("que efetuo preAutorizacao do PBM {string} para adesao {string}")
    public void que_efetuo_pre_autorizacao_do_pbm_para_adesao(String tipoPbm, String tipoPrograma) {
        Cache.valores.put(Util.rota.apply("TIPO_PBM"), tipoPbm);
        BuilderRequest.body.accept(Util.rota.apply((PbmGatewayService.POST_PRE_AUTORIZACAO)), PbmGatewayPreAutorizacaoGenerate.valueOf(Cache.valores.get(Util.rota.apply("TIPO_PBM"))).pojo(tipoPrograma.isEmpty() ? null : PbmEnum.valueOf(tipoPrograma)));
        PbmGatewayService.PostPreAutorizacao.run();
    }

    @Quando("efetuo autorizacao do PBM {string} na versao {string} da {string}")
    public void efetuo_autorizacao_do_pbm_na_versao_da(String tipoPbm, String versaoPbmAut, String versaoPbmPre) {
        AtomicReference<Boolean> executou = new AtomicReference<>(false);
        String identificador = getIdentificadorAutorizacao(versaoPbmPre, tipoPbm);
        String nsu = getNsuAutorizacao(versaoPbmPre, tipoPbm);
        assumingThat(versaoPbmAut.equals("PBM_GATEWAY"), () -> {
            new PostAutorizacao_v1Steps().executeFromPbm(identificador);
            executou.set(true);
        });
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("SEVEN"), () -> {
            new PostSevenAutorizacao_v4Steps().executePBmAutorizacao(PostAutorizacaoRequest_v4.builder()
                    .nsuPreAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("FUNCIONAL"), () -> {
            new PostFuncionalAutorizacao_v4Steps().executePBmAutorizacao(PostAutorizacaoRequest_v4.builder()
                    .nsuPreAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("ZICARD"), () -> {
            new PostZicardAutorizacao_v4Steps().executePBmAutorizacao(PostAutorizacaoRequest_v4.builder()
                    .nsuPreAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("EPHARMA"), () -> {
            new PostEpharmaAutorizacao_v4Steps().executePBmAutorizacao(PostAutorizacaoRequest_v4.builder()
                    .nsuPreAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(!executou.get(), () -> {
            throw new io.cucumber.java.PendingException("Cenario não codado");
        });
    }

    @E("efetuo o cancelamento do PBM {string} na versao {string} de uma preAutorizacao {string}")
    public void efetuo_o_cancelamento_do_pbm_na_versao_de_um_preAutorizacao(String tipoPbm, String versaoPbmCancelamento, String versaoPbmPre) {
        AtomicReference<Boolean> executou = new AtomicReference<>(false);
        String identificador = getIdentificadorAutorizacao(versaoPbmPre, tipoPbm);
        String nsu = getNsuAutorizacao(versaoPbmPre, tipoPbm);

        assumingThat(versaoPbmCancelamento.equals("PBM_GATEWAY"), () -> {
            new PostCancelamento_v1Steps().executeCancelamentoFromPbm(identificador);
            executou.set(true);
        });
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("FUNCIONAL"), () -> {
            new PostFuncionalCancelamento_v4Steps().executeCancelamentoFromPbm(PostCancelamentoRequest_v4.builder()
                    .nsuAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("ZICARD"), () -> {
            new PostZicardCancelamento_v4Steps().executeCancelamentoFromPbm(PostCancelamentoRequest_v4.builder()
                    .nsuAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("EPHARMA"), () -> {
            new PostEpharmaCancelamento_v4Steps().executeCancelamentoFromPbm(PostCancelamentoRequest_v4.builder()
                    .nsuAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("SEVEN"), () -> {
            new PostSevenCancelamento_v4Steps().executeCancelamentoFromPbm(PostCancelamentoRequest_v4.builder()
                    .nsuAutorizacao(nsu)
                    .identificadorTransacao(identificador).build());
            executou.set(true);
        });
        assumingThat(!versaoPbmCancelamento.equals("") && !executou.get(), () -> {
            throw new io.cucumber.java.PendingException("Cenario não codado");
        });
    }

    @Entao("sistema processa a autorizacao do PBM {string} na versao {string}:")
    public void sistema_processa_a_autorizacao_do_pbm_na_versao(String tipoPbm, String versaoPbmAut, DataTable dataTable) {
        assumingThat(versaoPbmAut.equals("PBM_GATEWAY"), () -> new PostAutorizacao_v1Steps().sistema_processa_pbm_gateway_service_v1_post_autorizacao(dataTable));
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("FUNCIONAL"), () -> new PostFuncionalAutorizacao_v4Steps().sistema_processa_pbm_service_v4_post_funcional_autorizacao(dataTable));
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("ZICARD"), () -> new PostZicardAutorizacao_v4Steps().sistema_processa_pbm_service_v4_post_zicard_autorizacao(dataTable));
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("EPHARMA"), () -> new PostEpharmaAutorizacao_v4Steps().sistema_processa_pbm_service_v4_post_epharma_autorizacao(dataTable));
        assumingThat(versaoPbmAut.equals("PBM") && tipoPbm.contains("SEVEN"), () -> new PostSevenAutorizacao_v4Steps().sistema_processa_pbm_service_v4_post_seven_autorizacao(dataTable));
    }

    @Entao("sistema processa o cancelamento do PBM {string} na versao {string}:")
    public void sistema_processa_o_cancelamento_do_pbm_na_versao(String tipoPbm, String versaoPbmCancelamento, DataTable dataTable) {
        assumingThat(versaoPbmCancelamento.equals("PBM_GATEWAY"), () -> new PostCancelamento_v1Steps().sistema_processa_pbm_gateway_service_v1_post_cancelamento(dataTable));
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("FUNCIONAL"), () -> new PostFuncionalCancelamento_v4Steps().sistema_processa_pbm_service_v4_post_funcional_cancelamento(dataTable));
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("ZICARD"), () -> new PostZicardCancelamento_v4Steps().sistema_processa_pbm_service_v4_post_zicard_cancelamento(dataTable));
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("EPHARMA"), () -> new PostEpharmaCancelamento_v4Steps().sistema_processa_pbm_service_v4_post_epharma_cancelamento(dataTable));
        assumingThat(versaoPbmCancelamento.equals("PBM") && tipoPbm.contains("SEVEN"), () -> new PostSevenCancelamento_v4Steps().sistema_processa_pbm_service_v4_post_seven_cancelamento(dataTable));
    }

    @Quando("efetuo adesao do PBM {string}:")
    public void efetuo_adesao_do_pbm(String tipoPbm) throws JsonProcessingException {
        List<PostPreAutorizacaoResponse_v1_deviationFlux_transactionControl> fieldsControl = Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class).getDeviationFlux().getTransactionControl();
        List<PostPreAutorizacaoResponse_v1_deviationFlux_formAccess_fields> fields = Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class).getDeviationFlux().getFormAccess().get(0).getFields();
        PostPreAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class);
        BuilderRequest.body.accept(Util.rota.apply(PbmGatewayService.POST_ADESAO), PbmGatewayAdesaoGenerate.valueOf(Cache.valores.get(Util.rota.apply("TIPO_PBM"))).pojo(response));
    }

    @Entao("sistema processa PbmGatewayService - v1 - PostAdesao:")
    public void sistemaProcessaPbmGatewayServiceVPostAdesao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_ADESAO)).getServiceResponse()
                , String.class
        );
    }

    @Entao("sistema processa a adesao do PBM {string}:")
    public void sistema_processa_a_adesao_do_pbm(String tipoPbm, DataTable dataTable) throws Exception {
        PbmGatewayService.PostAdesao.run();
        sistemaProcessaPbmGatewayServiceVPostAdesao(dataTable);
    }

    @Quando("efetuo preAutorizacao do PBM {string}")
    public void efetuo_pre_autorizacao_do_pbm_na_versao(String tipoPbm) {
        PbmGatewayService.PostPreAutorizacao.run();
    }

    public String getNsuAutorizacao(String versaoPbmPre, String tipoPbm) {
        AtomicReference<String> nsu = new AtomicReference<>();
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("FUNCIONAL"), () -> {
            nsu.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_FUNCIONAL_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostFuncionalPreAutorizacaoResponse_v4.class).getNsuPreAutorizacao());
        });
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("ZICARD"), () -> {
            nsu.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_ZICARD_PREAUTORIZACAO)).getServiceResponse().getObjectBody(PostZicardPreAutorizacaoResponse_v4.class).getNsuPreAutorizacao());
        });
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("EPHARMA"), () -> {
            nsu.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_EPHARMA_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostEpharmaPreAutorizacaoResponse_v4.class).getNsuPreAutorizacao());
        });
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("SEVEN"), () -> {
            nsu.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_SEVEN_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PreAutorizacaoResponse_v4.class).getNsuPreAutorizacao());
        });
        assumingThat(versaoPbmPre.equals("PBM_GATEWAY"), () -> {
            nsu.set(Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class).getNsuPreAuthorization());
        });
        return nsu.get();
    }

    public String getIdentificadorAutorizacao(String versaoPbmPre, String tipoPbm) {
        AtomicReference<String> indenticadortransacao = new AtomicReference<>();
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("FUNCIONAL"), () -> {
            indenticadortransacao.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_FUNCIONAL_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostFuncionalPreAutorizacaoResponse_v4.class).getIdentificadorTransacao());
        });
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("ZICARD"), () -> {
            indenticadortransacao.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_ZICARD_PREAUTORIZACAO)).getServiceResponse().getObjectBody(PostZicardPreAutorizacaoResponse_v4.class).getIdentificadorTransacao());
        });
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("EPHARMA"), () -> {
            indenticadortransacao.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_EPHARMA_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostEpharmaPreAutorizacaoResponse_v4.class).getIdentificadorTransacao());
        });
        assumingThat(versaoPbmPre.equals("PBM") && tipoPbm.contains("SEVEN"), () -> {
            indenticadortransacao.set(Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_SEVEN_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PreAutorizacaoResponse_v4.class).getIdentificadorTransacao());
        });
        assumingThat(versaoPbmPre.equals("PBM_GATEWAY"), () -> {
            indenticadortransacao.set(Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class).getTransactionIdentify());
        });
        return indenticadortransacao.get();
    }

}
