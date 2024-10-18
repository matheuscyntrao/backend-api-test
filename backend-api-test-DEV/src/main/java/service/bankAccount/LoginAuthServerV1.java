package service.bankAccount;

import model.tioPatinhas.bankAccount.request.PostLoginAuthV1Request;
import utils.Util;
import utils.mapper.ObjectMapperUtils;
import utils.properties.LoginTokenProperties;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface LoginAuthServerV1 extends ServiceBase {

    String dominio = "/authorization/oauth";
    String url = Util.uri.apply("authorization") + dominio;

    String POST_LOGIN_AUTH = "AppToken-v1-PostLoginAuthorization";

    Runnable postLoginAuthorization = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_LOGIN_AUTH)).getServiceSpecs();
        specs.header.putIfAbsent("Authorization", LoginTokenProperties.authorization);
        specs.setFormData(ObjectMapperUtils.transformObjectToMap(buildLoginRequest()));

        String endpoint = "/token";

        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.postFormData.accept(specs, Util.rota.apply(POST_LOGIN_AUTH));
    };

    static PostLoginAuthV1Request buildLoginRequest() {
        return PostLoginAuthV1Request.builder()
                .grant_type("password")
                .password(LoginTokenProperties.password)
                .username(LoginTokenProperties.username)
                .build();
    }
}
