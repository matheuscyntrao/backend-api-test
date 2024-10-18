package service.avengers.mostruario;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Mostruariov4 extends ServiceBase {

    String dominio = "/mostruario";
    String url = Util.uri.apply("mostruario-service") + dominio;

    String POST_IDENTIFICADOR = "Mostruario-v4-PostIdentificador";

    Runnable postIdentificador = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_IDENTIFICADOR)).getServiceSpecs();
        String endpoint = "/v4/packs/identificador";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_IDENTIFICADOR));
    };
}
