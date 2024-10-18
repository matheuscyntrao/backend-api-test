package stepdef.digital.shoppingCart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.response.ShippingLockerResponse_v1;
import service.digital.shoppingCart.Shipping_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class ShoppingcartShippingGetlocker_v1Steps {
    @Dado("possuo dados para ShoppingCart - Shipping - GetShoppingShippingLocker_v1 param:")
    public void possuo_dados_para_shopping_cart_shipping_get_shopping_shipping_locker_v1_param(Map<String, String> param) {
        BuilderRequest.param.accept(Util.rota.apply(Shipping_v1.GET_SHOPPING_SHIPPING_LOCKER), param);
    }

    @Quando("executo ShoppingCart - Shipping - GetShoppingShippingLocker_v1")
    public void executo_shopping_cart_shipping_get_shopping_shipping_locker_v1() {
        Shipping_v1.getShoppingShippingLocker.run();
    }

    @Entao("sistema processa ShoppingCart - Shipping - GetShoppingShippingLocker_v1:")
    public void sistema_processa_shopping_cart_shipping_get_shopping_shipping_locker_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Shipping_v1.GET_SHOPPING_SHIPPING_LOCKER)).getServiceResponse()
                , ShippingLockerResponse_v1.class
        );
    }
}
