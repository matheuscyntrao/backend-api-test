package service.coupon;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CouponV1 extends ServiceBase {

    String url = Util.uri.apply("coupon-service") + "/coupon";

    String POST_COUPON = "Coupon-v1-PostCoupon";
    String POST_COUPON_DATA = "Coupon-v1-PostCouponData";
    String PUT_COUPON_DATA = "Coupon-v1-PutCouponData";
    String GET_COUPON_BY_ID = "Coupon-v1-GetCouponById";
    String PATCH_ACTIVATE_COUPON_BY_ID = "Coupon-v1-PatchActivateCouponByCouponId";
    String PATCH_INACTIVATE_COUPON_BY_ID = "Coupon-v1-PatchActivateCouponByCouponId";

    Runnable postCoupon = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_COUPON)).getServiceSpecs();
        String endpoint = "/v1/coupon";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_COUPON));
    };

    Runnable postCouponData = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_COUPON_DATA)).getServiceSpecs();
        String endpoint = "/v1/coupon/data";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_COUPON_DATA));
    };

    Runnable putCouponData = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_COUPON_DATA)).getServiceSpecs();
        String endpoint = "/v1/coupon/data/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_COUPON_DATA));
    };

    Runnable getCouponById = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_COUPON_BY_ID)).getServiceSpecs();
        String endpoint = "/v1/coupon/data/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_COUPON_BY_ID));
    };

    Runnable patchActivate = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ACTIVATE_COUPON_BY_ID)).getServiceSpecs();
        String endpoint = "/v1/coupon/{id}/activate";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ACTIVATE_COUPON_BY_ID));
    };

    Runnable patchInactivate = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_INACTIVATE_COUPON_BY_ID)).getServiceSpecs();
        String endpoint = "/v1/coupon/{id}/inactivate";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_INACTIVATE_COUPON_BY_ID));
    };

}
