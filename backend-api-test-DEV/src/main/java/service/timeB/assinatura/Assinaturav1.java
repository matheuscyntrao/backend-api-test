package service.timeB.assinatura;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Assinaturav1 extends ServiceBase {

    String dominio = "/assinatura";
    String url = Util.uri.apply("assinatura-service") + dominio;

    String GET_DESCONTOPROGRESSIVO_LISTA_CODIGOFILIAL_CODIGOITEM_CODIGOCONVENIO = "Assinatura-v1-GetDescontoProgressivoListaCodigoFilialCodigoItemCodigoConvenio";
    String POST_ASSINA = "Assinatura-v1-PostAssina";
    String DELETE_SIGNATUREID_CANCELA = "Assinatura-v1-DeleteSignatureIdCancela";
    String DELETE_ITEM_SIGNATUREITEMID_CANCELAR = "Assinatura-v1-DeleteItemSignatureItemIdCancelar";
    String PATCH_ITEM_SIGNATUREITEMID_SUBSTITUIR = "Assinatura-v1-PatchItemSignatureItemIdSubstituir";
    String GET_LISTAR_CODIGOCLIENTE = "Assinatura-v1-GetListarCodigoCliente";
    String GET_IDASSINATURA = "Assinatura-v1-GetIdAssinatura";
    String GET_PERIODICIDADE = "Assinatura-v1-GetPeriodicidade";
    String GET_PERIODICIDADE_IDPERIODO = "Assinatura-v1-GetPeriodicidadeIdPeriodo";
    String POST_BLOQUEIO = "Assinatura-v1-PostBloqueio";
    String PATCH_DESBLOQUEIO = "Assinatura-v1-PatchDesbloqueio";
    String GET_CONSULTABLOQUEIO_PERFIL_CODIGOPERFIL = "Assinatura-v1-GetConsultaBloqueioPerfilCodigoPerfil";
    String GET_CONSULTABLOQUEIO_PERFIL_CODIGOPERFIL_CODIGOITEM = "Assinatura-v1-GetConsultaBloqueioPerfilCodigoPerfilCodigoItem";
    String GET_CONFIGURACAO = "Assinatura-v1-GetConfiguracao";
    String POST_FRETEGRATIS = "Assinatura-v1-PostFreteGratis";
    String PATCH_FRETEGRATIS_ENCERRAR = "Assinatura-v1-PatchFreteGratisEncerrar";
    String GET_FRETEGRATIS_DISPONIVEL_PERFIL_CODIGOPERFIL = "Assinatura-v1-GetFreteGratisDisponivelPerfilCodigoPerfil";

    Runnable getDescontoProgressivoListaCodigoFilialCodigoItemCodigoConvenio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_DESCONTOPROGRESSIVO_LISTA_CODIGOFILIAL_CODIGOITEM_CODIGOCONVENIO)).getServiceSpecs();
        String endpoint = "/v1/descontoprogressivo/lista/codigofilial/{codigofilial}/codigoitem/{codigoitem}/codigoconvenio/{codigoconvenio}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_DESCONTOPROGRESSIVO_LISTA_CODIGOFILIAL_CODIGOITEM_CODIGOCONVENIO));
    };

    Runnable postAssina = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ASSINA)).getServiceSpecs();
        String endpoint = "/v1/assina";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ASSINA));
    };

    Runnable deleteSignatureIdCancela = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_SIGNATUREID_CANCELA)).getServiceSpecs();
        String endpoint = "/v1/{signatureId}/cancela";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_SIGNATUREID_CANCELA));
    };

    Runnable deleteItemSignatureItemIdCancelar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_ITEM_SIGNATUREITEMID_CANCELAR)).getServiceSpecs();
        String endpoint = "/v1/item/{signatureItemId}/cancelar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_ITEM_SIGNATUREITEMID_CANCELAR));
    };

    Runnable patchItemSignatureItemIdSubstituir = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ITEM_SIGNATUREITEMID_SUBSTITUIR)).getServiceSpecs();
        String endpoint = "/v1/item/{signatureItemId}/substituir";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ITEM_SIGNATUREITEMID_SUBSTITUIR));
    };

    Runnable getListarCodigoCliente = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LISTAR_CODIGOCLIENTE)).getServiceSpecs();
        String endpoint = "/v1/listar/codigoCliente/{codigoCliente}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LISTAR_CODIGOCLIENTE));
    };

    Runnable getIdAssinatura = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_IDASSINATURA)).getServiceSpecs();
        String endpoint = "/v1/{idAssinatura}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_IDASSINATURA));
    };

    Runnable getPeriodicidade = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PERIODICIDADE)).getServiceSpecs();
        String endpoint = "/v1/periodicidade";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PERIODICIDADE));
    };

    Runnable getPeriodicidadeIdPeriodo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PERIODICIDADE_IDPERIODO)).getServiceSpecs();
        String endpoint = "/v1/periodicidade/{idPeriodo}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PERIODICIDADE_IDPERIODO));
    };

    Runnable postBloqueio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_BLOQUEIO)).getServiceSpecs();
        String endpoint = "/v1/bloqueio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_BLOQUEIO));
    };

    Runnable patchDesbloqueio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_DESBLOQUEIO)).getServiceSpecs();
        String endpoint = "/v1/desbloqueio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_DESBLOQUEIO));
    };

    Runnable getConsultaBloqueioPerfilCodigoPerfil = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONSULTABLOQUEIO_PERFIL_CODIGOPERFIL)).getServiceSpecs();
        String endpoint = "/v1/consultabloqueio/perfil/{codigoPerfil}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONSULTABLOQUEIO_PERFIL_CODIGOPERFIL));
    };

    Runnable getConsultaBloqueioPerfilCodigoPerfilItemCodigoItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONSULTABLOQUEIO_PERFIL_CODIGOPERFIL_CODIGOITEM)).getServiceSpecs();
        String endpoint = "/v1/consultabloqueio/perfil/{codigoPerfil}/item/{codigoItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONSULTABLOQUEIO_PERFIL_CODIGOPERFIL_CODIGOITEM));
    };

    Runnable getConfiguracao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONFIGURACAO)).getServiceSpecs();
        String endpoint = "/v1/configuracao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONFIGURACAO));
    };

    Runnable postFreteGratis = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FRETEGRATIS)).getServiceSpecs();
        String endpoint = "/v1/frete-gratis";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FRETEGRATIS));
    };

    Runnable patchFreteGratisEncerrar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_FRETEGRATIS_ENCERRAR)).getServiceSpecs();
        String endpoint = "/v1/frete-gratis/encerrar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_FRETEGRATIS_ENCERRAR));
    };

    Runnable getFreteGratisDisponivelPerfilCodigoPerfil = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FRETEGRATIS_DISPONIVEL_PERFIL_CODIGOPERFIL)).getServiceSpecs();
        String endpoint = "/v1/frete-gratis/disponivel/perfil/{codigoPerfil}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FRETEGRATIS_DISPONIVEL_PERFIL_CODIGOPERFIL));
    };
}
