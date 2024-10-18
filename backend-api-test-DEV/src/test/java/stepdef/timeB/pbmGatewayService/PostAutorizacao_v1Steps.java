package stepdef.timeB.pbmGatewayService;

import entity.timeb.pbmGateway.PbmAutorizacaoOmniEntity;
import entity.timeb.pbmGateway.PbmItensAutorizacaoEntity;
import enums.PbmFuncionalPreAutorizacaoGenerate;
import enums.PbmGatewayPreAutorizacaoGenerate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbmGatewayService.response.PostAutorizacaoResponse_v1;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;
import queries.timeB.pbm.PbmTransacoesOmni;
import service.timeB.pbm.Pbmv4;
import service.timeB.pbmGatewayService.PbmGatewayService;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostAutorizacao_v1Steps {

    private static String ROTA = PbmGatewayService.POST_AUTORIZACAO;

    @Dado("que efetuo preAutorizacao do PBMna versao")
    public void que_efetuo_pre_autorizacao_do_pbm_na_versao() {
        BuilderRequest.body.accept(Util.rota.apply(Pbmv4.POST_FUNCIONAL_PRE_AUTORIZACAO), PbmFuncionalPreAutorizacaoGenerate.AUTORIZACAO_VALIDA.pojo());
        Pbmv4.postFuncionalPreAutorizacao.run();
    }

    @Dado("que efetuo preAutorizacao do PBM {string}")
    public void que_efetuo_pre_autorizacao_do_pbm_na_versao(String tipoPbm) {
        Cache.valores.put(Util.rota.apply("TIPO_PBM"), tipoPbm);
        BuilderRequest.body.accept(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO), PbmGatewayPreAutorizacaoGenerate.valueOf(Cache.valores.get(Util.rota.apply("TIPO_PBM"))).pojo(null));
        PbmGatewayService.PostPreAutorizacao.run();

    }

    @Quando("efetuo autorizacao do PBM {string}")
    public void efetuo_autorizacao_do_pbm_na_versao_da(String tipoPbm) {
        String identificador = getIdentificadorAutorizacao();
        new PostAutorizacao_v1Steps().executeFromPbm(identificador);
    }


    @Dado("possuo dados para PbmGatewayService - v1 - PostAutorizacao path:")
    public void possuo_dados_para_pbm_gateway_service_v1_post_autorizacao_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo PbmGatewayService - v1 - PostAutorizacao")
    public void executo_pbm_gateway_service_v1_post_autorizacao() {
        PbmGatewayService.postAutorizacao.run();
    }

    @Entao("sistema processa PbmGatewayService - v1 - PostAutorizacao:")
    public void sistema_processa_pbm_gateway_service_v1_post_autorizacao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostAutorizacaoResponse_v1.class
        );
    }

    public void executeFromPbm(String identificador) {
        possuo_dados_para_pbm_gateway_service_v1_post_autorizacao_path(Map.of("identificadorTransacao", identificador));
        executo_pbm_gateway_service_v1_post_autorizacao();
    }

    @Entao("valido PbmGatewayService - v1 - Tabela de pbm_autorizacoes_omni")
    public void valido_pbm_gateway_service_v1_tabela_de_pbm_autorizacoes_omni() {
        PostAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostAutorizacaoResponse_v1.class);
        PbmAutorizacaoOmniEntity autorizacao = PbmTransacoesOmni.getIAutorizacaoOmni(response.getIdentificadorTransacao());
        assertAll(
                () -> assertEquals(autorizacao.getIdentificadorTransacao(), response.getIdentificadorTransacao(), "Erro na identificacao"),
                () -> assertEquals(autorizacao.getNsuAuthorization(), response.getNsuAuthorization(), "Erro na Autorizacao"),
                () -> assertEquals(autorizacao.getPriceNetAuthorized(), response.getItens().get(0).getPriceNetAuthorized(), "Erro valor autorizado")
        );
    }


    @Entao("valido PbmGatewayService - v1 - Tabela de pbm_itens_autorizacao_omni")
    public void valido_pbm_gateway_service_v1_tabela_de_pbm_itens_transacao_omni() {
        PostAutorizacaoResponse_v1 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostAutorizacaoResponse_v1.class);
        PbmItensAutorizacaoEntity itensAutorizados = PbmTransacoesOmni.getItensAutorizacao(response.getIdentificadorTransacao());
        assertAll(
                () -> assertEquals(itensAutorizados.getIdentificadorTransacao(), response.getIdentificadorTransacao()),
                () -> assertEquals(itensAutorizados.getPanvelCode(), response.getItens().get(0).getPanvelCode()),
                () -> assertEquals(itensAutorizados.getEan(), response.getItens().get(0).getEan()),
                () -> assertEquals(itensAutorizados.getQuantityAuthorized(), response.getItens().get(0).getQuantityAuthorized()),
                () -> assertEquals(itensAutorizados.getAuthorizedCovenantValue(), response.getItens().get(0).getPriceNetAuthorized())
        );
    }

    public String getIdentificadorAutorizacao() {
        AtomicReference<String> indenticadortransacao = new AtomicReference<>();
        indenticadortransacao.set(Cache.chamadas.get(Util.rota.apply(PbmGatewayService.POST_PRE_AUTORIZACAO)).
                getServiceResponse().getObjectBody(PostPreAutorizacaoResponse_v1.class).
                getTransactionIdentify());
        return indenticadortransacao.get();
    }

}
