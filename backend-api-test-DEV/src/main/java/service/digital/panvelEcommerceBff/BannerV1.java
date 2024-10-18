package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface BannerV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_BANNERS = "PanvelEcommerceBff-v1-GetBanners";

    Runnable getBanners = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_BANNERS)).getServiceSpecs();
        String endpoint = "/v1/home";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_BANNERS));
    };

}
