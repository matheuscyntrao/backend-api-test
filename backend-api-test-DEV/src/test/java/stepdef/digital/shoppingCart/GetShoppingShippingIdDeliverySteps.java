package stepdef.digital.shoppingCart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.response.ShippingDeliveryResponse_v1;
import service.digital.shoppingCart.Shipping_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetShoppingShippingIdDeliverySteps {
    @Dado("possuo dados para ShoppingCart - Shipping - GetShippingDelivery_v1 path:")
    public void possuo_dados_para_shopping_cart_shipping_get_shipping_delivery_v1_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Shipping_v1.GET_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY), dataTable);
    }

    @Quando("executo ShoppingCart - Shipping - GetShippingDelivery_v1")
    public void executo_shopping_cart_shipping_get_shipping_delivery_v1() {
        Shipping_v1.getShoppingShippingShoppingcartidDellivery.run();
    }

    @Entao("sistema processa ShoppingCart - Shipping - GetShippingDelivery_v1:")
    public void sistema_processa_shopping_cart_shipping_get_shipping_delivery_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Shipping_v1.GET_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY)).getServiceResponse()
                , ShippingDeliveryResponse_v1.class
        );
    }
}
