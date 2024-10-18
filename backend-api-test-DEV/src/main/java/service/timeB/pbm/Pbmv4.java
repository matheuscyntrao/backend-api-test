package service.timeB.pbm;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pbmv4 extends ServiceBase {

    String dominio = "/pbms";
    String url = Util.uri.apply("pbm-service") + dominio;

    String GET_EPHARMA_CONVENIOS_FILIAL_CANAL_VENDA_TIPO_PROGRAMA = "Pbm-v4-GetEpharmaConveniosFilialCanalVendaTipoPrograma";
    String POST_EPHARMA_PRE_AUTORIZACAO = "Pbm-v4-PostEpharmaPreAutorizacao";
    String POST_EPHARMA_AUTORIZACAO = "Pbm-v4-PostEpharmaAutorizacao";
    String POST_EPHARMA_CANCELAMENTO = "Pbm-v4-PostEpharmaCancelamento";
    String POST_FUNCIONAL_PRE_AUTORIZACAO = "Pbm-v4-PostFuncionalPreAutorizacao";
    String POST_FUNCIONAL_AUTORIZACAO = "Pbm-v4-PostFuncionalAutorizacao";
    String POST_FUNCIONAL_CANCELAMENTO = "Pbm-v4-PostFuncionalCancelamento";
    String PUT_FUNCIONAL_ATUALIZA_PRODUTOS_PROGRAMA = "Pbm-v4-PutFuncionalAtualizaProdutosPrograma";
    String POST_FUNCIONAL_AUTENTICACAO = "Pbm-v4-PostFuncionalAutenticacao";
    String POST_SEVEN_PRE_AUTORIZACAO = "Pbm-v4-PostSevenPreAutorizacao";
    String POST_SEVEN_AUTORIZACAO = "Pbm-v4-PostSevenAutorizacao";
    String POST_SEVEN_CANCELAMENTO = "Pbm-v4-PostSevenCancelamento";
    String GET_VIDALINK_CONVENIOS_TIPO_TIPOCONVENIO = "Pbm-v4-GetVidalinkConveniostipoTipoConvenio";
    String GET_VIDALINK_VALIDACARTAO_CNPJ_CONVENIO_NUMERO_CARTAO = "Pbm-v4-GetVidalinkValicacaocartaoCnpjConvenioNumeroCartao";
    String POST_VIDALINK_PREAUTORIZACAO = "Pbm-v4-PostVidalinkPreautorizacao";
    String POST_VIDALINK_AUTORIZACAO = "Pbm-v4-PostVidalinkAutorizacao";
    String POST_VIDALINK_CANCELAMENTO = "Pbm-v4-PostVidalinkCancelamento";
    String POST_VIDALINK_UPLOADRECEITA = "Pbm-v4-PostVidalinkUploadReceita";
    String GET_VIDALINK_AUDITORIA_CONSULTA_IDENTIFICADORTRANSACAO = "Pbm-v4-GetVidalinkAuditoriaConsultaIdentificadorTransacao";
    String PATCH_VIDALINK_CONVENIOS = "Pbm-v4-PatchVidalinkConvenios";
    String PATCH_VIDALINK_PRODUTOS = "Pbm-v4-PatchVidalinkProdutos";
    String PATCH_VIDALINK_RECEITAS = "Pbm-v4-PatchVidalinkReceitas";
    String POST_ZICARD_PREAUTORIZACAO = "Pbm-v4-PostZicardPreAutorizacao";
    String POST_ZICARD_PRODUTOS_CARGA = "Pbm-v4-PostZicardProdutosCarga";
    String GET_ZICARD_PRODUTOS = "Pbm-v4-GetZicardProdutos";
    String POST_ZICARD_AUTORIZACAO = "Pbm-v4-PostZicardAutorizacao";
    String POST_ZICARD_LOGIN = "Pbm-v4-PostZicardLogin";
    String POST_ZICARD_CONFIRMACAO = "Pbm-v4-PostZicardConfirmacao";
    String POST_ZICARD_CANCELAMENTO = "Pbm-v4-PostZicardCancelamento";
    String POST_ZICARD_DEVOLUCAO = "Pbm-v4-PostZicardDevolucao";

    Runnable getEpharmaConveniosFilialCanalVendaTipoPrograma = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_EPHARMA_CONVENIOS_FILIAL_CANAL_VENDA_TIPO_PROGRAMA)).getServiceSpecs();
        String endpoint = "/v4/epharma/convenios/filial/{codigoFilial}/canal-venda/{canalVenda}/tipo-programa/{tipoPrograma}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_EPHARMA_CONVENIOS_FILIAL_CANAL_VENDA_TIPO_PROGRAMA));
    };

    Runnable postEpharmaPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/epharma/pre-autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_PRE_AUTORIZACAO));
    };

    Runnable postEpharmaAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/epharma/autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_AUTORIZACAO));
    };

    Runnable postEpharmaCancelamento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_CANCELAMENTO)).getServiceSpecs();
        String endpoint = "/v4/epharma/cancelamento";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_CANCELAMENTO));
    };

    Runnable postFuncionalPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/funcional/pre-autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_PRE_AUTORIZACAO));
    };

    Runnable postFuncionalAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/funcional/autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_AUTORIZACAO));
    };

    Runnable postFuncionalCancelamento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_CANCELAMENTO)).getServiceSpecs();
        String endpoint = "/v4/funcional/cancelamento";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_CANCELAMENTO));
    };

    Runnable putFuncionalAtualizaProdutosPrograma = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_FUNCIONAL_ATUALIZA_PRODUTOS_PROGRAMA)).getServiceSpecs();
        String endpoint = "/v4/funcional/atualiza-produtos-programa";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_FUNCIONAL_ATUALIZA_PRODUTOS_PROGRAMA));
    };

    Runnable postFuncionalAutenticacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_AUTENTICACAO)).getServiceSpecs();
        String endpoint = "/v4/funcional/autenticacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(POST_FUNCIONAL_AUTENTICACAO));
    };

    Runnable postSevenPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SEVEN_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/seven/pre-autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SEVEN_PRE_AUTORIZACAO));
    };

    Runnable postSevenAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SEVEN_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/seven/autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SEVEN_AUTORIZACAO));
    };

    Runnable postSevenCancelamento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SEVEN_CANCELAMENTO)).getServiceSpecs();
        String endpoint = "/v4/seven/cancelamento";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SEVEN_CANCELAMENTO));
    };

    Runnable getVidalinkConvenioTipoConvenio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_VIDALINK_CONVENIOS_TIPO_TIPOCONVENIO)).getServiceSpecs();
        String endpoint = "/v4/vidalink/convenios/tipo/{tipoConvenio}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_VIDALINK_CONVENIOS_TIPO_TIPOCONVENIO));
    };

    Runnable getVidalinkValidaCartaoCnpjConvenioNumeroCartao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_VIDALINK_VALIDACARTAO_CNPJ_CONVENIO_NUMERO_CARTAO)).getServiceSpecs();
        String endpoint = "/v4/vidalink/valida-cartao/cnpj/{cnpj}/convenio/{convenio}/numero/{cartao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_VIDALINK_VALIDACARTAO_CNPJ_CONVENIO_NUMERO_CARTAO));
    };

    Runnable postVidalinkPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_VIDALINK_PREAUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/vidalink/pre-autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_VIDALINK_PREAUTORIZACAO));
    };

    Runnable postVidalinkAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_VIDALINK_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/vidalink/autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_VIDALINK_AUTORIZACAO));
    };

    Runnable postVidalinkCancelamento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_VIDALINK_CANCELAMENTO)).getServiceSpecs();
        String endpoint = "/v4/vidalink/cancelamento";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_VIDALINK_CANCELAMENTO));
    };

    Runnable postVidalinkUploadReceita = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_VIDALINK_UPLOADRECEITA)).getServiceSpecs();
        String endpoint = "/v4/vidalink/upload-receita";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_VIDALINK_UPLOADRECEITA));
    };

    Runnable getVidalinkAuditoriaConsultaIdentificadorTransacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_VIDALINK_AUDITORIA_CONSULTA_IDENTIFICADORTRANSACAO)).getServiceSpecs();
        String endpoint = "/v4/vidalink/auditoria/consulta/{identificadorTransacao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_VIDALINK_AUDITORIA_CONSULTA_IDENTIFICADORTRANSACAO));
    };

    Runnable patchVidalinkConvenios = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_VIDALINK_CONVENIOS)).getServiceSpecs();
        String endpoint = "/v4/vidalink/convenios";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_VIDALINK_CONVENIOS));
    };

    Runnable patchVidalinkProdutos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_VIDALINK_PRODUTOS)).getServiceSpecs();
        String endpoint = "/v4/vidalink/produtos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_VIDALINK_PRODUTOS));
    };

    Runnable patchVidalinkReceitas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_VIDALINK_RECEITAS)).getServiceSpecs();
        String endpoint = "/v4/vidalink/receitas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_VIDALINK_RECEITAS));
    };

    Runnable postZicardPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_PREAUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/zicard/pre-autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_PREAUTORIZACAO));
    };

    Runnable postZicardProdutosCarga = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_PRODUTOS_CARGA)).getServiceSpecs();
        String endpoint = "/v4/zicard/produtos/carga";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_PRODUTOS_CARGA));
    };

    Runnable getZicardProdutos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ZICARD_PRODUTOS)).getServiceSpecs();
        String endpoint = "/v4/zicard/produtos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ZICARD_PRODUTOS));
    };

    Runnable postZicardAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v4/zicard/autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_AUTORIZACAO));
    };

    Runnable postZicardLogin = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_LOGIN)).getServiceSpecs();
        String endpoint = "/v4/zicard/login";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_LOGIN));
    };

    Runnable postZicardConfirmacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_CONFIRMACAO)).getServiceSpecs();
        String endpoint = "/v4/zicard/confirmacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_CONFIRMACAO));
    };

    Runnable postZicardCancelamento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_CANCELAMENTO)).getServiceSpecs();
        String endpoint = "/v4/zicard/cancelamento";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_CANCELAMENTO));
    };

    Runnable postZicardDevolucao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_DEVOLUCAO)).getServiceSpecs();
        String endpoint = "/v4/zicard/devolucao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_DEVOLUCAO));
    };
}
