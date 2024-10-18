package stepdef.timeB.marketplace;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import model.timeB.marketplaceSeller.request.DeliveriesRequest_v1;
import model.timeB.marketplaceSeller.request.DeliveriesRequest_v1_Volume;
import model.timeB.marketplaceSeller.response.DeliveriesResponse_v1;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class APIFretesSteps {
    @Dado("possuo dados para MarketplaceSeller - v1 - API fretes:")
    public void possuo_dados_para_marketplace_seller_v1_api_fretes(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(MarketplaceSeller.POST_API_FRETES), CucumberUtils.getObjectBody(dataTable, DeliveriesRequest_v1.class));
    }

    @Dado("possuo dados para MarketplaceSeller - v1 - API fretes volumes:")
    public void possuo_dados_para_marketplace_seller_v1_api_fretes_volumes(DataTable dataTable) throws JsonProcessingException {
        DeliveriesRequest_v1 deliveriesRequest_v1 = Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_API_FRETES)).getServiceSpecs().getObjectBody(DeliveriesRequest_v1.class);
        deliveriesRequest_v1.setVolumes(Arrays.asList(CucumberUtils.getObjectBody(dataTable, DeliveriesRequest_v1_Volume[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_API_FRETES)).getServiceSpecs().setBody(deliveriesRequest_v1);
    }

    @Dado("executo MarketplaceSeller - v1 - API fretes")
    public void executo_api_fretes_marketplace_seller_v1() {
        MarketplaceSeller.postAPIFretes.run();
    }

    @Entao("sistema processa MarketplaceSeller - v1 - API fretes:")
    public void sistema_processa_marketplace_seller_v1_api_fretes(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_API_FRETES)).getServiceResponse()
                , DeliveriesResponse_v1.class
        );
    }
}
