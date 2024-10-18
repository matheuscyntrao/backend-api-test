package stepdef.timeB.marketplace;

import entity.marketplaceSeller.TokenEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import queries.timeB.marketplaceSeller.TokenQuerie;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidaTokenSteps {

    public List<TokenEntity> tokenEntities;

    @Dado("que efetuo MarketplaceSeller - v1 - Token {string}")
    public void que_efetuo_marketplace_seller_v1_token(String cenario) {
        TokenQuerie.updateToken(cenario);
        tokenEntities = TokenQuerie.getToken();
        BuilderRequest.simple.accept(Util.rota.apply(MarketplaceSeller.POST_TOKEN));
    }

    @Quando("executo MarketplaceSeller - v1 - Token")
    public void executo_marketplace_seller_v1_token() {
        MarketplaceSeller.postToken.run();
    }

    @Entao("sistema processa MarketplaceSeller - v1 - Token:")
    public void sistema_processa_marketplace_seller_v1_token(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_TOKEN)).getServiceResponse()
                , String.class
        );
    }

    @Entao("valido MarketplaceSeller - v1 - Token {string}")
    public void valido_marketplace_seller_v1_token(String cenario) {
        List<TokenEntity> tokenAfterRequest = TokenQuerie.getToken();
        if (cenario.equals("valido")) {
            assertAll(
                    () -> assertEquals(tokenEntities.get(0).getBearerToken(), tokenAfterRequest.get(0).getBearerToken()),
                    () -> assertEquals(tokenEntities.get(0).getExpiracaoToken(), tokenAfterRequest.get(0).getExpiracaoToken()));
        } else {
            assertAll(
                    () -> assertNotEquals(tokenEntities.get(0).getBearerToken(), tokenAfterRequest.get(0).getBearerToken()),
                    () -> assertNotEquals(tokenEntities.get(0).getExpiracaoToken(), tokenAfterRequest.get(0).getExpiracaoToken()));
        }
    }

}
