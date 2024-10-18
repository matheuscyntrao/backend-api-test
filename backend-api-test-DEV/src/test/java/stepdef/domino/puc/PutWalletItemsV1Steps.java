package stepdef.domino.puc;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.pucservice.request.PutWalletItemsRequest_v1;
import model.domino.pucservice.request.PutWalletItemsRequest_v1_Client;
import model.domino.pucservice.request.PutWalletItemsRequest_v1_Item;
import model.domino.pucservice.request.PutWalletItemsRequest_v1_Item_Treatment;
import model.timeB.pbm.request.PostAutorizacaoRequest_v4;
import service.domino.puc.Pucv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class PutWalletItemsV1Steps {
    private static String ROTA = Pucv1.PUT_WALLET_ITEMS;

    @Dado("possuo dados para WalletItems - v1 - PutWalletItems:")
    public void possuo_dados_para_wallet_items_v1_put_wallet_items(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, PutWalletItemsRequest_v1.class));
    }

    @Dado("possuo dados para para WalletItems - v1 - PutWalletItems_Client:")
    public void possuo_dados_para_para_wallet_items_v1_put_wallet_items_client(DataTable dataTable) throws JsonProcessingException {
        PutWalletItemsRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PutWalletItemsRequest_v1.class);
        body.setClient(CucumberUtils.getObjectBody(dataTable, PutWalletItemsRequest_v1_Client.class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Dado("possuo dados para para WalletItems - v1 - PutWalletItems_Item:")
    public void possuo_dados_para_para_wallet_items_v1_put_wallet_items_item(DataTable dataTable) throws JsonProcessingException {
        PutWalletItemsRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PutWalletItemsRequest_v1.class);
        body.setItem(CucumberUtils.getObjectBody(dataTable, PutWalletItemsRequest_v1_Item.class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Dado("possuo dados para para WalletItems - v1 - PutWalletItems_Item_Treatment:")
    public void possuo_dados_para_para_wallet_items_v1_put_wallet_items_item_treatment(DataTable dataTable) throws JsonProcessingException {
        PutWalletItemsRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PutWalletItemsRequest_v1.class);
        body.getItem().setTreatment(CucumberUtils.getObjectBody(dataTable, PutWalletItemsRequest_v1_Item_Treatment.class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo WalletItems - v1 - PutWalletItems")
    public void executo_wallet_items_v1_put_wallet_items() {
        Pucv1.putWalletItems.run();
    }

    @Entao("sistema processa WalletItems - v1 - PutWalletItems:")
    public void sistema_processa_wallet_items_v1_put_wallet_items(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , String.class
        );
    }
}
