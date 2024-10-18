package service.avengers.item;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Itemv1 extends ServiceBase {

    String dominio = "/item";
    String url = Util.uri.apply("item-service") + dominio;

    String GET_ITENS = "Item-v1-GetItens";
    String GET_ITENS_COD_ITEM = "Item-v1-GetItensCodItem";
    String POST_ITENS_AVISEME = "Item-v1-PostItensAviseme";
    String GET_ITENS_AUTOCOMPLETE = "Item-v1-GetItensAutocomplete";

    Runnable getItens = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS)).getServiceSpecs();
        String endpoint = "/v1/itens";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS));
    };

    Runnable getItensCodItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_COD_ITEM)).getServiceSpecs();
        String endpoint = "/v1/itens/{codItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_COD_ITEM));
    };

    Runnable postItensAviseme = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ITENS_AVISEME)).getServiceSpecs();
        String endpoint = "/v1/itens/aviseme";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ITENS_AVISEME));
    };

    Runnable getItensAutocomplete = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_AUTOCOMPLETE)).getServiceSpecs();
        String endpoint = "/v1/itens/autocomplete/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_AUTOCOMPLETE));
    };
}
