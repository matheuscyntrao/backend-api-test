package service.digital.campaign;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Campaign_v1 extends ServiceBase {

    String dominio = "/campaign";
    String url = Util.uri.apply("campaign-service") + dominio;
    String GET_CAMPAIGN = "Campaign-v1-GetCampaign";

    Runnable getCampaign = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CAMPAIGN)).getServiceSpecs();
        String endpoint = "/v1/campaign/{campaignId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CAMPAIGN));
    };
}
