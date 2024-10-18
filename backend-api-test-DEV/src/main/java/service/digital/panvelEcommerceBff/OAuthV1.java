package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface OAuthV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String POST_O_AUTH = "PanvelEcommerceBff-v1-PostOAuth";

    Runnable postOAuth = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_O_AUTH)).getServiceSpecs();
        String endpoint = "/v1/oauth";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_O_AUTH));
    };

}
