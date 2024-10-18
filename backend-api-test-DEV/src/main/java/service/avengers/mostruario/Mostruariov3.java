package service.avengers.mostruario;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Mostruariov3 extends ServiceBase {

    String dominio = "/mostruario";
    String url = Util.uri.apply("mostruario-service") + dominio;

    String GET_BARCODE = "Mostruario-v3-GetBarcode";
    String POST_DETALHE = "Mostruario-v3-PostDetalhe";
    String POST_DETALHE_LOCAL = "Mostruario-v3-PostDetalheLocal";
    String POST_LISTA = "Mostruario-v3-PostList";
    String GET_PRECOS = "Mostruario-v3-GetPrecos";
    String GET_ITEM_ALTERNATIVOS = "Mostruario-v3-GetItemAlternativos";
    String GET_ITEM_GENERICOS = "Mostruario-v3-GetItemGenericos";
    String GET_ITEM_PRINCIPIOATIVO = "Mostruario-v3-GetItemPrincipioAtivo";
    String GET_ITEM_REFERENCIA = "Mostruario-v3-GetItemReferencia";
    String GET_ITEM_SIMILARES = "Mostruario-v3-GetItemSimilares";
    String GET_ESTRUTURA_PACKCODE = "Mostruario-v3-GetEstruturaPackCode";
    String GET_FILIAL_CANAL = "Mostruario-v3-GetFilialCanal";
    String POST_IDENTIFICADOR = "Mostruario-v3-PostIdentificador";

    Runnable getBarcode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_BARCODE)).getServiceSpecs();
        String endpoint = "/v3/itens/barcode=${barcode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_BARCODE));
    };

    Runnable postDetalhe = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DETALHE)).getServiceSpecs();
        String endpoint = "/v3/itens/detalhe";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DETALHE));
    };

    Runnable postDetalheLocal = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DETALHE_LOCAL)).getServiceSpecs();
        specs.setUrl("http://172.16.17.239:9006/mostruario/v3/itens/detalhe");
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DETALHE_LOCAL));
    };

    Runnable postLista = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_LISTA)).getServiceSpecs();
        String endpoint = "/v3/itens/lista";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_LISTA));
    };

    Runnable getPrecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PRECOS)).getServiceSpecs();
        String endpoint = "/v3/itens/precos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PRECOS));
    };

    Runnable getItemAlternativos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_ALTERNATIVOS)).getServiceSpecs();
        String endpoint = "/v3/itens/{item}/alternativos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_ALTERNATIVOS));
    };

    Runnable getItemGenericos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_GENERICOS)).getServiceSpecs();
        String endpoint = "/v3/itens/{item}/genericos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_GENERICOS));
    };

    Runnable getItemPrincipioAtivo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_PRINCIPIOATIVO)).getServiceSpecs();
        String endpoint = "/v3/itens/{item}/principioativo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_PRINCIPIOATIVO));
    };

    Runnable getItemReferencia = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_REFERENCIA)).getServiceSpecs();
        String endpoint = "/v3/itens/{item}/referencia";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_REFERENCIA));
    };

    Runnable getItemSimilares = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_SIMILARES)).getServiceSpecs();
        String endpoint = "/v3/itens/{item}/similares";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_SIMILARES));
    };

    Runnable getEstruturaPackCode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ESTRUTURA_PACKCODE)).getServiceSpecs();
        String endpoint = "/v3/packs/estrutura/{packcode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ESTRUTURA_PACKCODE));
    };

    Runnable getFilialCanal = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_CANAL)).getServiceSpecs();
        String endpoint = "/v3/packs/filial/{filial}/canal/{canal}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_CANAL));
    };

    Runnable postIdentificador = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_IDENTIFICADOR)).getServiceSpecs();
        String endpoint = "/v3/packs/identificador";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_IDENTIFICADOR));
    };
}
