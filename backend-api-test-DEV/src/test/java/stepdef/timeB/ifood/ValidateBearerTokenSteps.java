package stepdef.timeB.ifood;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.ifood.BearerTokenEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.ifood.request.AutenticacaoGerarTokenRequest;
import model.timeB.ifood.response.AutenticacaoGerarTokenResponse;
import org.json.JSONObject;
import org.junit.Assert;
import queries.timeB.ifood.GetClientTokenQuerie;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ValidateBearerTokenSteps {

    static String ROTA = MarketplaceSeller.POST_IFOOD_TOKEN;

    @Dado("que efetuo Ifood - v1 - Bearer Token Validation {string}")
    public void que_efetuo_ifood_v1_bearer_token_validation(String fluxo) throws JsonProcessingException {
        BearerTokenEntity data;
        data = GetClientTokenQuerie.getClientIdAndSecretForToken();
        AutenticacaoGerarTokenRequest body = new AutenticacaoGerarTokenRequest();
        if (fluxo.contains("CLIENT_SECRET_INVALIDO")) {
            data.setClientSecret("XXXX");
        } else if (fluxo.contains("CLIENT_ID_INVALIDO")) {
            data.setClientId("XXXX");
        }
        body.setClientSecret(data.getClientSecret());
        body.setClientId(data.getClientId());
        BuilderRequest.body.accept(Util.rota.apply(ROTA), body);
    }

    @Quando("executo Ifood - v1 - Bearer Token Validation")
    public void executo_ifood_v1_bearer_token_validation() {
        MarketplaceSeller.postIfoodToken.run();
    }

    @E("sistema processa Ifood - v1 - Bearer Token Validation")
    public void sistema_processa_ifood_v1_bearer_token_validation(DataTable dataTable) throws Exception {
        if (Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200) {
            ResponseValidator.validaResponse(dataTable
                    , Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_IFOOD_TOKEN)).getServiceResponse()
                    , AutenticacaoGerarTokenResponse.class
            );
        }
    }

    @Entao("valido Ifood - v1 - Bearer Token Validation")
    public void valido_ifood_v1_bearer_token_validation(Map<String, String> datatable) {
        JSONObject response = new JSONObject(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().body);
        Integer status = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode();
        assumingThat(status == 200, () -> {
            Assert.assertNotNull(response.get("access_token"));
            Assert.assertEquals("Bearer", response.get("token_type"));
            Assert.assertNotNull(response.get("expires_in"));
        });
        assumingThat(status != 200, () -> {
            Assert.assertEquals("invalid_client", response.get("error"));
            String errorDescription = (String) response.get("error_description");
            if (status == 401) {
                Assert.assertTrue(errorDescription.contains(datatable.get("message")));
            } else {
                Assert.assertTrue(errorDescription.contains(datatable.get("message")));
            }
        });
    }
}
