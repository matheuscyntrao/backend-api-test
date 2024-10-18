package service.digital.category;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Category_v1 extends ServiceBase {

    String dominio = "/category";
    String url = Util.uri.apply("category-service") + dominio;
    String GET_CATEGORY = "Campaign-v1-GetCampaign";

    Runnable getCategory = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CATEGORY)).getServiceSpecs();
        String endpoint = "/v1/category/{categoryId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CATEGORY));
    };
}
