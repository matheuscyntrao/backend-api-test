package stepdef.digital.campaign;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.campaign.response.GetCampaignResponse_v1;
import service.digital.campaign.Campaign_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetCampaign_v1Steps {
    private static String ROTA = Campaign_v1.GET_CAMPAIGN;

    @Dado("que possuo dados para Campaign - v1 - GetCampaign path:")
    public void que_possuo_dados_para_campaign_v1_get_campaign_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);
    }

    @E("que possuo dados para Campaign - v1 - GetCampaign param:")
    public void que_possuo_dados_para_campaign_v1_get_campaign_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo Campaign - v1 - GetCampaign")
    public void executo_campaign_v1_get_campaign() {
        Campaign_v1.getCampaign.run();
    }

    @Entao("sistema processa Campaign - v1 - GetCampaign:")
    public void sistema_processa_campaign_v1_get_campaign(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetCampaignResponse_v1.class
        );
    }
}
