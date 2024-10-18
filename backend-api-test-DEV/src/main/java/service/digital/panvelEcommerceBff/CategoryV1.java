package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CategoryV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String POST_CATEGORY = "PanvelEcommerceBff-v1-PostCategory";

    Runnable postCategory = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CATEGORY)).getServiceSpecs();
        String endpoint = "/v1/category/search/category";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CATEGORY));
    };

}
