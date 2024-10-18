package service.avengers.lostSale;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface LostSalev1 extends ServiceBase {

    String dominio = "/lost-sale";  //TODO: verificar depois
    String url = Util.uri.apply("lost-sale-service") + dominio;

    String POST_LOST_SALE = "LostSale-v1-PostLostSale";

    Runnable postLostSale = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_LOST_SALE)).getServiceSpecs();
        String endpoint = "/v1/lost-sale";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_LOST_SALE));
    };
}
