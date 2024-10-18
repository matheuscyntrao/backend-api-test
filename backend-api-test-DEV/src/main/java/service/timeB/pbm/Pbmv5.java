package service.timeB.pbm;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pbmv5 extends ServiceBase {

    String dominio = "/pbms";
    String url = Util.uri.apply("pbm-service") + dominio;
    String POST_ZICARD_CONFIRMACAO = "Pbm-v5-PostZicardConfirmacao";

    Runnable postZicardConfirmacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ZICARD_CONFIRMACAO)).getServiceSpecs();
        String endpoint = "/v5/zicard/confirmacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ZICARD_CONFIRMACAO));
    };
}
