package service.avengers.item;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Itemv2 extends ServiceBase {

    String dominio = "/item";
    String url = Util.uri.apply("item-service") + dominio;

    String GET_ITENS = "Item-v2-GetItens";
    String POST_ITENS_SEARCH = "Item-v2-PostItensSearch";
    String POST_ITENS_AVISEME = "Item-v2-PostItensAviseme";
    String GET_ITENS_AUTOCOMPLETE = "Item-v2-GetItensAutocomplete";

    Runnable getItens = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS)).getServiceSpecs();
        String endpoint = "/v2/itens";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS));
    };

    Runnable postItensSearch = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ITENS_SEARCH)).getServiceSpecs();
        String endpoint = "/v2/itens/search";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ITENS_SEARCH));
    };

    Runnable postItensAviseme = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ITENS_AVISEME)).getServiceSpecs();
        String endpoint = "/v2/itens/aviseme";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ITENS_AVISEME));
    };

    Runnable getItensAutocomplete = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_AUTOCOMPLETE)).getServiceSpecs();
        String endpoint = "/v2/itens/autocomplete/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_AUTOCOMPLETE));
    };
}
