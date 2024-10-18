package service.digital.authorization;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Authorizationv1 extends ServiceBase {

    String dominio = "/authorization";
    String url = Util.uri.apply("authorization-service") + dominio;

    String POST_AUTHORIZATION_TOKEN = "Authorization-v1-PostToken";

    Runnable postToken = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_AUTHORIZATION_TOKEN)).getServiceSpecs();
        String endpoint = "/oauth/token";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_AUTHORIZATION_TOKEN));
    };

}
