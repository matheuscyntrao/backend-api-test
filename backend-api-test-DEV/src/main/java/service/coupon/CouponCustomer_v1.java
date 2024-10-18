package service.coupon;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CouponCustomer_v1 extends ServiceBase {

    String dominio = "/coupon";
    String url = Util.uri.apply("coupon-service") + dominio;

    String POST_CUSTOMER = "Coupon-v1-PostCustomer";
    String GET_CUSTOMER_BY_COUPON_ID = "Coupon-v1-GetCustomerById";

    Runnable getCustomersByCouponId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CUSTOMER_BY_COUPON_ID)).getServiceSpecs();
        String endpoint = "/v1/coupon/{couponId}/customer";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CUSTOMER_BY_COUPON_ID));
    };

    Runnable postCustomers = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CUSTOMER)).getServiceSpecs();
        String endpoint = "/v1/coupon/{couponId}/customer";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CUSTOMER));
    };


}
