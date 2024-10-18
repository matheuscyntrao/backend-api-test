package stepdef.digital.shoppingCart;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.request.PatchPaymentsCashRequest_v1;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1;
import service.digital.shoppingCart.Payment_v1;
import service.digital.shoppingCart.Shipping_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class PatchPaymentsCash_v1Steps {
    @Dado("que possuo dados para ShoppingCart - Payment - PatchPaymentsCash:")
    public void que_possuo_dados_para_shopping_cart_payment_patch_payments_cash(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Payment_v1.PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CASH), CucumberUtils.getObjectBody(dataTable, PatchPaymentsCashRequest_v1.class));
    }

    @Dado("que possuo dados para ShoppingCart - Payment - PatchPaymentsCash path:")
    public void que_possuo_dados_para_shopping_cart_payment_patch_payments_cash_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Payment_v1.PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CASH), dataTable);
    }

    @Quando("executo ShoppingCart - Payment - PatchItemCodItem_v1")
    public void executo_shopping_cart_payment_patch_item_cod_item_v1() {
        Payment_v1.patchShoppingShoppingcartcodePaymentsCash.run();
    }

    @Entao("sistema processa ShoppingCart - Payment - PatchItemCodItem_v1:")
    public void sistema_processa_shopping_cart_payment_patch_item_cod_item_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Payment_v1.PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CASH)).getServiceResponse()
                , ShoppingCartResponse_v1.class
        );
    }

    public void executo(PatchPaymentsCashRequest_v1 body, Map<String, String> path)  {
        ShoppingCartResponse_v1 response_v1 = Cache.chamadas.get(Util.rota.apply(Shipping_v1.PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class);
        BuilderRequest.body.accept(Util.rota.apply(Payment_v1.PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CASH), body);
        que_possuo_dados_para_shopping_cart_payment_patch_payments_cash_path(path);
        executo_shopping_cart_payment_patch_item_cod_item_v1();
    }

}
