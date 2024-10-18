package stepdef.digital.shoppingCart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.response.PaymentsPosResponse_v1;
import service.digital.shoppingCart.Payment_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetShoppingShoppingcartcodePaymentsPosSteps {
    @Dado("possuo dados para ShoppingCart - Payment - GetShoppingcartcodePaymentsPos_v1 path:")
    public void possuo_dados_para_shopping_cart_payment_get_shoppingcartcode_payments_pos_v1_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Payment_v1.GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_POS), dataTable);
    }

    @Quando("executo ShoppingCart - Payment - GetShoppingcartcodePaymentsPos_v1")
    public void executo_shopping_cart_payment_get_shoppingcartcode_payments_pos_v1() {
        Payment_v1.getShoppingShoppingcartcodePaymentsPos.run();
    }

    @Entao("sistema processa ShoppingCart - Payment - GetShoppingcartcodePaymentsPos_v1:")
    public void sistema_processa_shopping_cart_payment_get_shoppingcartcode_payments_pos_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Payment_v1.GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_POS)).getServiceResponse()
                , PaymentsPosResponse_v1.class
        );
    }
}
