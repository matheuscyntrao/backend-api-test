package service.domino.enterpriseCard;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface EnterpriseCardv1 extends ServiceBase {

    String dominio = "/enterprise-card";
    String url = Util.uri.apply("enterprise-card-service") + dominio;

    String POST_CONVENANT = "EnterpriseCard-v1-PostConvenant";
    String GET_ENTERPRISECARD_AUTHORIZATIONS_AUTHORIZATION = "EnterpriseCard-v1-GetEnterpriseCardAuthorizationsAuthorization";
    String POST_ENTERPRISECARD_AUTHORIZATIONS = "EnterpriseCard-v1-PostEnterpriseCardAuthorizations";
    String GET_ENTERPRISECARD_AUTHORIZATIONS = "EnterpriseCard-v1-GetEnterpriseCardAuthorizations";

    Runnable postConvenant = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONVENANT)).getServiceSpecs();
        String endpoint = "/v1/covenant";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONVENANT));
    };

    Runnable getEnterpriseCardAuthorizationsAuthorization = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTERPRISECARD_AUTHORIZATIONS_AUTHORIZATION)).getServiceSpecs();
        String endpoint = "/v1/enterprise-card/authorizations/authorization";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTERPRISECARD_AUTHORIZATIONS_AUTHORIZATION));
    };

    Runnable postEnterpriseCardAuthorizations = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ENTERPRISECARD_AUTHORIZATIONS)).getServiceSpecs();
        String endpoint = "/v1/enterprise-card/authorizations";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(POST_ENTERPRISECARD_AUTHORIZATIONS));
    };

    Runnable getEnterpriseCardAuthorizations = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTERPRISECARD_AUTHORIZATIONS)).getServiceSpecs();
        String endpoint = "/v1/enterprise-card/authorizations";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTERPRISECARD_AUTHORIZATIONS));
    };
}
