package service.digital.shippingService;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ShippingService_v1 extends ServiceBase {

    String dominio = "/shipping";
    String url = Util.uri.apply("shipping-service") + dominio;
    String POST_DELIVERIES = "ShippingService-v1-PostDeliveries";


    Runnable postDeliveries = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DELIVERIES)).getServiceSpecs();
        String endpoint = "/v1/deliveries/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DELIVERIES));
    };
}
