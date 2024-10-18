package service.digital.autenticacao;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Autenticacao_v1 extends ServiceBase {

    String dominio = "/bff-ecommerce";
    String url = Util.uri.apply("autenticacao") + dominio;

    String POST_AUTENTICACAO = "Autenticacao-v1-PostAutenticacao";

    Runnable postAutenticacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_AUTENTICACAO)).getServiceSpecs();
        String endpoint = "/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_AUTENTICACAO));
    };

}
