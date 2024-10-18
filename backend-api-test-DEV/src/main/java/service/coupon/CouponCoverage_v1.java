package service.coupon;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CouponCoverage_v1 extends ServiceBase {

    String dominio = "/coupon";
    String url = Util.uri.apply("coupon-service") + dominio;

    String POST_COVERAGE = "Coupon-v1-PostCoverage";
    String GET_COVERAGE_BY_COUPON_ID = "Coupon-v1-GetCoverageById";

    Runnable postCoverage = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_COVERAGE)).getServiceSpecs();
        String endpoint = "/v1/coupon/{couponId}/coverage";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_COVERAGE));
    };

    Runnable getCoverageByCouponId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_COVERAGE_BY_COUPON_ID)).getServiceSpecs();
        String endpoint = "/v1/coupon/{couponId}/coverage";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_COVERAGE_BY_COUPON_ID));
    };

}
