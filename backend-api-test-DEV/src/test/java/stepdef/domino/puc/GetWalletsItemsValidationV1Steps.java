package stepdef.domino.puc;

import dataSource.mongo.shoppingCart.PucDatastore;
import entity.domino.puc.ItemsValidatorEntity;
import enums.domino.puc.PucClients;
import enums.domino.puc.PucWalletValidationItem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.pucservice.response.GetWalletsItemsValidationResponse_v1;
import service.domino.puc.Pucv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class GetWalletsItemsValidationV1Steps {
    private static String ROTA = Pucv1.GET_WALLET_ITEMS_VALIDATION;

    @Dado("possuo dados para ItemsValidation - v1 - GetWalletsItemsValidation {string}")
    public void possuo_dados_para_items_validation_v1_get_wallets_items_validation(String fluxoPuc) {
        BuilderRequest.param.accept(Util.rota.apply((ROTA)), PucWalletValidationItem.valueOf(fluxoPuc).pojo());
    }

    @Quando("executo ItemsValidation - v1 - GetWalletsItemsValidation")
    public void executo_items_validation_v1_get_wallets_items_validation() {
        Pucv1.getWalletItemsValidation.run();
    }

    @Entao("sistema processa ItemsValidation - v1 - GetWalletsItemsValidation:")
    public void sistema_processa_items_validation_v1_get_wallets_items_validation(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetWalletsItemsValidationResponse_v1.class);
    }
}
