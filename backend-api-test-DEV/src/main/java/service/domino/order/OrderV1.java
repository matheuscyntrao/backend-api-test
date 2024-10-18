package service.domino.order;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface OrderV1 extends ServiceBase {

    String dominio = "/order";
    String url = Util.uri.apply("order-service") + dominio;

    String POST_ECOMMERCE_ORDERS = "Order-v1-EcommercerOrders";

    Runnable postEcommerceOrders= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ECOMMERCE_ORDERS)).getServiceSpecs();
        String endpoint = "/v1/ecommerce/orders";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ECOMMERCE_ORDERS));
    };

}
