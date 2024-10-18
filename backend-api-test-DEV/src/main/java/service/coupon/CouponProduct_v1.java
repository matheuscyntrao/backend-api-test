package service.coupon;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CouponProduct_v1 extends ServiceBase {

    String url = Util.uri.apply("coupon-service").concat("/coupon");

    String POST_PRODUCT = "Coupon-v1-PostProduct";
    String GET_PRODUCT_BY_COUPON_ID = "Coupon-v1-GetProductByCouponId";

    Runnable getProductsByCouponId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PRODUCT_BY_COUPON_ID)).getServiceSpecs();
        String endpoint = "/v1/coupon/{couponId}/product";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PRODUCT_BY_COUPON_ID));
    };

    Runnable postProducts = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRODUCT)).getServiceSpecs();
        String endpoint = "/v1/coupon/{couponId}/product";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRODUCT));
    };

}
