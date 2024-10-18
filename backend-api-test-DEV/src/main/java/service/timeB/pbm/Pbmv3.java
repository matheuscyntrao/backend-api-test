package service.timeB.pbm;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pbmv3 extends ServiceBase {

    String dominio = "/pbms";
    String url = Util.uri.apply("pbm-service") + dominio;

    String GET_CONSULTAR_DETALHE_ORIGEM_FILIAL_ITEM_SEVEN_COD_ITEM = "Pbm-v3-GetConsultarDetalheOrigemFilialItemSevenCodItem";
    String GET_CONSULTAR_DETALHE_ORIGEM_FILIAL = "Pbm-v3-GetConsultarDetalheOrigemFilial";
    String GET_DETALHE_PROGRAMA_ITEM_FILIAL_CANAL = "Pbm-v3-GetDetalheProgramaItemFilialCanal";
    String GET_LISTAR = "Pbm-v3-GetListar";
    String GET_LISTA_REFERENCIAL = "Pbm-v3-GetListaReferencial";
    String GET_LISTA_REFERENCIAL_CONVENIO_ADMINISTRACAO = "Pbm-v3-GetListaReferencialConvenioAdministracao";
    String GET_LISTA_REFERENCIAL_DETALHAR_ITEM_CONVENIO_ADMINISTRADORA = "Pbm-v3-GetListaReferencialDetalharItemConvenioAdministracao";
    String POST_DETALHE_PROGRAMA_ITENS = "Pbm-v3-PostDetalheProgramaItens";
    String POST_EPHARMA_AUTORIZACAO = "Pbm-v3-PostEpharmaAutorizacao";
    String POST_EPHARMA_CONSULTAR = "Pbm-v3-PostEpharmaConsultar";
    String DELETE_EPHARMA_AUTORIZACAO_CANCELAR = "Pbm-v3-DeleteEpharmaAutorizacaoCancelar";
    String GET_EPHARMA_CONVENIOS_FILIAL = "Pbm-v3-GetEpharmaConveniosFilial";
    String POST_EPHARMA_CONSULTAR_SALDO = "Pbm-v3-PostEpharmaConsultarSaldo";
    String POST_EPHARMA_INICIALIZACAO = "Pbm-v3-PostEpharmaInicializacao";
    String POST_SEVEN_PRE_AUTORIZACAO = "Pbm-v3-PostSevenPreAutorizacao";
    String POST_SEVEN_ATIVACAO = "Pbm-v3-PostSevenAtivacao";
    String POST_SEVEN_LOGON = "Pbm-v3-PostSevenLogon";
    String GET_FUNCIONAL_AUTENTICACAO_ORIGEM = "Pbm-v3-GetFuncionalAutenticacaoOrigem";
    String GET_FUNCIONAL_CONSULTA_BENEFICIARIO_ORIGEM = "Pbm-v3-GetFuncionalConsultaBeneficiarioOrigem";
    String POST_FUNCIONAL_CONSULTA_PRECO = "Pbm-v3-PostFuncionalConsultaPreco";
    String POST_FUNCIONAL_PRE_AUTORIZACAO = "Pbm-v3-PostFuncionalPreAutorizacao";
    String POST_FUNCIONAL_CONSULTA_PROGRAMA = "Pbm-v3-PostFuncionalConsultaPrograma";

    Runnable getConsultarDetalheOrigemFilialItemSevenCodItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONSULTAR_DETALHE_ORIGEM_FILIAL_ITEM_SEVEN_COD_ITEM)).getServiceSpecs();
        String endpoint = "/v3/consultardetalhe/origem/{codOrigem}/filial/{codFilial}/itemSeven/{codItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONSULTAR_DETALHE_ORIGEM_FILIAL_ITEM_SEVEN_COD_ITEM));
    };

    Runnable getConsultarDetalheOrigemFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONSULTAR_DETALHE_ORIGEM_FILIAL)).getServiceSpecs();
        String endpoint = "/v3/consultardetalhe/origem/{codOrigem}/filial/{codFilial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONSULTAR_DETALHE_ORIGEM_FILIAL));
    };

    Runnable getDetalheProgramaItemFilialCanal = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_DETALHE_PROGRAMA_ITEM_FILIAL_CANAL)).getServiceSpecs();
        String endpoint = "/v3/detalhe-programa/item/{codigoItem}/filial/{codigoFilial}/canal/{codigoCanalVenda}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_DETALHE_PROGRAMA_ITEM_FILIAL_CANAL));
    };

    Runnable getListar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LISTAR)).getServiceSpecs();
        String endpoint = "/v3/listar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LISTAR));
    };

    Runnable getListaReferencial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LISTA_REFERENCIAL)).getServiceSpecs();
        String endpoint = "/v3/lista-referencial";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LISTA_REFERENCIAL));
    };

    Runnable getListaReferencialConvenioAdministradora = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LISTA_REFERENCIAL_CONVENIO_ADMINISTRACAO)).getServiceSpecs();
        String endpoint = "/v3/lista-referencial/convenio/{convenio}/administradora/{admConvenio}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LISTA_REFERENCIAL_CONVENIO_ADMINISTRACAO));
    };

    Runnable getListaReferencialDetalharItemConvenioAdministradora = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LISTA_REFERENCIAL_DETALHAR_ITEM_CONVENIO_ADMINISTRADORA)).getServiceSpecs();
        String endpoint = "/v3lista-referencial/detalhar-item/convenio/{convenio}/administradora/{admConvenio}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LISTA_REFERENCIAL_DETALHAR_ITEM_CONVENIO_ADMINISTRADORA));
    };

    Runnable postDetalheProgramaItens = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DETALHE_PROGRAMA_ITENS)).getServiceSpecs();
        String endpoint = "/v3/detalhe-programa/itens";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(POST_DETALHE_PROGRAMA_ITENS));
    };

    Runnable postEpharmaAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v3/epharma/autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_AUTORIZACAO));
    };

    Runnable postEpharmaConsultar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_CONSULTAR)).getServiceSpecs();
        String endpoint = "/v3/epharma/consultar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_CONSULTAR));
    };

    Runnable deleteEpharmaAutorizacaoCancelar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_EPHARMA_AUTORIZACAO_CANCELAR)).getServiceSpecs();
        String endpoint = "/v3/epharma/autorizacao/cancelar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_EPHARMA_AUTORIZACAO_CANCELAR));
    };

    Runnable getEpharmaConveniosFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_EPHARMA_CONVENIOS_FILIAL)).getServiceSpecs();
        String endpoint = "/v3/epharma/convenios/filial/{filial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_EPHARMA_CONVENIOS_FILIAL));
    };

    Runnable postEpharmaConsultarSaldo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_CONSULTAR_SALDO)).getServiceSpecs();
        String endpoint = "/v3/epharma/consultasaldo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_CONSULTAR_SALDO));
    };

    Runnable postEpharmaInicializacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_INICIALIZACAO)).getServiceSpecs();
        String endpoint = "/v3/epharma/inicializacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_INICIALIZACAO));
    };

    Runnable postSevenPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SEVEN_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v3/seven/preautorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SEVEN_PRE_AUTORIZACAO));
    };

    Runnable postSevenAticacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SEVEN_ATIVACAO)).getServiceSpecs();
        String endpoint = "/v3/seven/ativacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SEVEN_ATIVACAO));
    };

    Runnable postSevenLogon = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SEVEN_LOGON)).getServiceSpecs();
        String endpoint = "/v3/seven/logon";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SEVEN_LOGON));
    };

    Runnable getFuncionalAutenticacaoOrigem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FUNCIONAL_AUTENTICACAO_ORIGEM)).getServiceSpecs();
        String endpoint = "/v3/funcional/autenticacao/origem/{origem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FUNCIONAL_AUTENTICACAO_ORIGEM));
    };

    Runnable getFuncionalConsultaBeneficiarioDocumentoOrigem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FUNCIONAL_CONSULTA_BENEFICIARIO_ORIGEM)).getServiceSpecs();
        String endpoint = "/v3/funcional/consulta/beneficiario/{documento}/origem/{origem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FUNCIONAL_CONSULTA_BENEFICIARIO_ORIGEM));
    };

    Runnable postFuncionalConsultaPreco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_CONSULTA_PRECO)).getServiceSpecs();
        String endpoint = "/v3/funcional/consulta/preco";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_CONSULTA_PRECO));
    };

    Runnable postFuncionalPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v3/funcional/pre-autorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_PRE_AUTORIZACAO));
    };

    Runnable postFuncionalConsultaPrograma = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_CONSULTA_PROGRAMA)).getServiceSpecs();
        String endpoint = "/v3/funcional/consulta/programa";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_CONSULTA_PROGRAMA));
    };
}
