package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CampaignV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String POST_CAMPAIGN = "PanvelEcommerceBff-v1-PostCampaign";

    Runnable postCampaign = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CAMPAIGN)).getServiceSpecs();
        String endpoint = "/v1/campaign/search/campaign";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CAMPAIGN));
    };

}
