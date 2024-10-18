package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ItemDetailV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_ITEM_DETAIL_BY_PANVELCODE = "PanvelEcommerceBff-v1-GetItemDetailByPanvelCode";
    String GET_FIND_ITEM_LIST_AND_SUGGESTION_BY_SEARCH_TERM_AUTOCOMPLETE = "PanvelEcommerceBff-v1-GetFindItemListAndSuggestionBySearchTermAutocomplete";
    String GET_RECOMMENDATION = "PanvelEcommerceBff-v1-GetRecommendation";

    Runnable getItemDetailByPanvelCode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_DETAIL_BY_PANVELCODE)).getServiceSpecs();
        String endpoint = "/v1/item/{panvelCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_DETAIL_BY_PANVELCODE));
    };

    Runnable getFindItemListAndSuggestionBySearchTermAutocomplete = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIND_ITEM_LIST_AND_SUGGESTION_BY_SEARCH_TERM_AUTOCOMPLETE)).getServiceSpecs();
        String endpoint = "/v1/item/suggestions";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FIND_ITEM_LIST_AND_SUGGESTION_BY_SEARCH_TERM_AUTOCOMPLETE));
    };

    Runnable getRecommendation = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_RECOMMENDATION)).getServiceSpecs();
        String endpoint = "/v1/recommendation";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_RECOMMENDATION));
    };

}
