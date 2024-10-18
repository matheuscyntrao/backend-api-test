package stepdef.timeB.E2E;

import enums.PbmZicardPreAutorizacaoGenerate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.pbm.request.*;
import model.timeB.pbm.response.PostZicardAutorizacaoResponse_v4;
import model.timeB.pbm.response.PostZicardConfirmacaoResponse_v5;
import model.timeB.pbm.response.PostZicardPreAutorizacaoResponse_v4;
import service.timeB.pbm.Pbmv4;
import service.timeB.pbm.Pbmv5;
import stepdef.timeB.pbm.PostZicardAutorizacao_v4Steps;
import stepdef.timeB.pbm.PostZicardCancelamento_v4Steps;
import stepdef.timeB.pbm.PostZicardConfirmacao_v5Steps;
import stepdef.timeB.pbm.PostZicardDevolucao_v4Steps;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigDecimal;
import java.util.Arrays;

public class E2EPbmZicard_v4Steps {
    @Dado("que efetuo preAutorizacao do PBM zicard")
    public void que_efetuo_pre_autorizacao_do_pbm_zicard() {
        BuilderRequest.body.accept(Util.rota.apply(Pbmv4.POST_ZICARD_PREAUTORIZACAO), PbmZicardPreAutorizacaoGenerate.AUTORIZACAO_VALIDA.pojo());
        Pbmv4.postZicardPreAutorizacao.run();
    }

    @Quando("efetuo autorizacao do PBM zicard")
    public void efetuo_autorizacao_do_pbm_zicard() {
        PostAutorizacaoRequest_v4 response = Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_ZICARD_PREAUTORIZACAO)).getServiceResponse().getObjectBody(PostAutorizacaoRequest_v4.class);
        String nsu = response.getNsuPreAutorizacao();
        String identificador = response.getIdentificadorTransacao();
        new PostZicardAutorizacao_v4Steps().executePBmAutorizacao(PostAutorizacaoRequest_v4.builder()
                .nsuPreAutorizacao(nsu)
                .identificadorTransacao(identificador).build());
    }

    @Entao("sistema processa a autorizacao do PBM zicard:")
    public void sistema_processa_a_autorizacao_do_pbm_zicard(DataTable dataTable) throws Exception {
        new PostZicardAutorizacao_v4Steps().sistema_processa_pbm_service_v4_post_zicard_autorizacao(dataTable);

    }

    @Entao("efetuo o cancelamento do PBM zicard")
    public void efetuo_o_cancelamento_do_pbm_zicard() {
        PostZicardAutorizacaoResponse_v4 response = Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_ZICARD_AUTORIZACAO)).getServiceResponse().getObjectBody(PostZicardAutorizacaoResponse_v4.class);
        String nsu = response.getNsuAutorizacao();
        String identificador = response.getIdentificadorTransacao();
        new PostZicardCancelamento_v4Steps().executeCancelamentoFromPbm(PostCancelamentoRequest_v4.builder()
                .nsuAutorizacao(nsu)
                .identificadorTransacao(identificador).build());
    }

    @Entao("sistema processa o cancelamento do PBM zicard:")
    public void sistema_processa_o_cancelamento_do_pbm_zicard(DataTable dataTable) throws Exception {
        new PostZicardCancelamento_v4Steps().sistema_processa_pbm_service_v4_post_zicard_cancelamento(dataTable);
    }

    @Entao("efetuo a confirmacao do PBM zicard")
    public void efetuo_a_confirmacao_do_pbm_zicard() {
        PostZicardAutorizacaoResponse_v4 response = Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_ZICARD_AUTORIZACAO)).getServiceResponse().getObjectBody(PostZicardAutorizacaoResponse_v4.class);
        String nsu = response.getNsuAutorizacao();
        String identificador = response.getIdentificadorTransacao();
        Long cnpj = 92665611010130L;
        String estacao = "teste";
        String numeroCupom = response.getIdentificadorTransacao();
        Long codigoItem = response.getItens().get(0).getCodigoItem();
        BigDecimal valorDesconto = response.getItens().get(0).getPrecoLiquidoAutorizado();
        new PostZicardConfirmacao_v5Steps().executeConfirmacaoPbm(PostZicardConfirmacaoRequest_v5.builder()
                .cnpj(cnpj)
                .estacao(estacao)
                .numeroCupom(numeroCupom)
                .autorizacoes(Arrays.asList(PostZicardConfirmacaoRequest_v5_Autorizacoes.builder()
                                .nsuAutorizacao(nsu)
                                .identificadorTransacao(identificador)
                                .itens(Arrays.asList(PostZicardConfirmacaoRequest_v5_Autorizacoes_Itens.builder()
                                        .codigoItem(codigoItem)
                                        .valorDesconto(valorDesconto)
                                        .build()))
                        .build()))
                .build());
    }
    @Entao("sistema processa a confirmacao do PBM zicard:")
    public void sistema_processa_a_confirmacao_do_pbm_zicard(DataTable dataTable) throws Exception {
        new PostZicardConfirmacao_v5Steps().sistema_processa_pbm_service_v5_post_zicard_confirmacao(dataTable);
    }

    @Quando("efetuo a devolucao do PBM zicard")
    public void efetuo_a_devolucao_do_pbm_zicard() {
        PostZicardConfirmacaoResponse_v5 response = Cache.chamadas.get(Util.rota.apply(Pbmv5.POST_ZICARD_CONFIRMACAO)).getServiceResponse().getObjectBody(PostZicardConfirmacaoResponse_v5.class);
        PostZicardAutorizacaoResponse_v4 responseAutorizacao = Cache.chamadas.get(Util.rota.apply(Pbmv4.POST_ZICARD_AUTORIZACAO)).getServiceResponse().getObjectBody(PostZicardAutorizacaoResponse_v4.class);
        String nsu = response.getNsuConfirmacao();
        String identificador = responseAutorizacao.getIdentificadorTransacao();
        String cpfResponsavel = "02807802060";
        String cnpjEstabelecimento = "92665611010130";
        String estacao = "teste";
        String ean = responseAutorizacao.getItens().get(0).getEan();
        Integer quantidadeCancelar = responseAutorizacao.getItens().get(0).getQuantidadeAutorizada();
        new PostZicardDevolucao_v4Steps().executeDevolucaoPbm(PostZicardDevolucaoRequest_v4.builder()
                .nsuConfirmacao(nsu)
                .identificadorTransacao(identificador)
                .cpfResponsavel(cpfResponsavel)
                .cnpjEstabelecimento(cnpjEstabelecimento)
                .estacao(estacao)
                .itens(Arrays.asList(PostZicardDevolucaoRequest_v4_Itens.builder()
                        .ean(ean)
                        .quantidadeCancelar(quantidadeCancelar)
                        .build()))
                .build());
    }



    @Entao("sistema processa a devolucao do PBM zicard:")
    public void sistema_processa_a_devolucao_do_pbm_zicard(DataTable dataTable) throws Exception {
        new PostZicardDevolucao_v4Steps().sistema_processa_pbm_service_v4_post_zicard_devolucao(dataTable);
    }
}
