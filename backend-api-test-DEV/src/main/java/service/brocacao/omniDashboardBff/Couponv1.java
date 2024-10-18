package service.brocacao.omniDashboardBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Couponv1 extends ServiceBase {

    String dominio = "/omni-dashboard-bff";
    String url = Util.uri.apply("omni-dashboard-bff") + dominio;
    String GET_COUPON_BY_ID = "Brocacao-Bff-v1-GetCouponById";

    Runnable getCouponById = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_COUPON_BY_ID)).getServiceSpecs();
        String endpoint = "/v1/coupon/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_COUPON_BY_ID));
    };

}
