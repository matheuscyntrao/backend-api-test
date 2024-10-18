package stepdef.digital.shoppingCart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.response.ShippingResponse_v1;
import service.digital.shoppingCart.Shipping_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class ShoppingcartShippingGetshipping_v1Steps {
    @Dado("possuo dados para ShoppingCart - Shipping - GetShoppingShipping_v1")
    public void possuo_dados_para_shopping_cart_shipping_get_shopping_shipping_v1() {
        BuilderRequest.simple.accept(Util.rota.apply(Shipping_v1.GET_SHOPPING_SHIPPING));
    }

    @Quando("executo ShoppingCart - Shipping - GetShoppingShipping_v1")
    public void executo_shopping_cart_shipping_get_shopping_shipping_v1() {
        Shipping_v1.getShoppingShipping.run();
    }

    @Entao("sistema processa ShoppingCart - Shipping - GetShoppingShipping_v1:")
    public void sistema_processa_shopping_cart_shipping_get_shopping_shipping_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Shipping_v1.GET_SHOPPING_SHIPPING)).getServiceResponse()
                , ShippingResponse_v1.class
        );
    }
}