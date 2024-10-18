package stepdef.digital.shoppingCart;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.request.ShippingLockerRequest_v1;
import service.digital.shoppingCart.Shipping_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class PostShippingLockerSteps {
    @Dado("possuo dados para ShoppingCart - Shipping - PostShoppingcartidLocker_v1:")
    public void possuo_dados_para_shopping_cart_shipping_post_shoppingcartid_locker_v1(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Shipping_v1.POST_SHOPPING_SHIPPING_SHOPPINGCARTID_LOCKER), CucumberUtils.getObjectBody(dataTable, ShippingLockerRequest_v1.class));
    }

    @Dado("possuo dados para ShoppingCart - Shipping - PostShoppingcartidLocker_v1 path:")
    public void possuo_dados_para_shopping_cart_shipping_post_shoppingcartid_locker_v1_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Shipping_v1.POST_SHOPPING_SHIPPING_SHOPPINGCARTID_LOCKER), dataTable.get("shoppingCartId").equals("VALIDO") ? Map.of("shoppingCartId", Cache.valores.get(Util.rota.apply("CARRINHO"))) : dataTable);
    }

    @Quando("executo ShoppingCart - Shipping - PostShoppingcartidLocker_v1")
    public void executo_shopping_cart_shipping_post_shoppingcartid_locker_v1() {
        Shipping_v1.postShoppingShippingShoppingcartidLocker.run();
    }

    @Entao("sistema processa ShoppingCart - Shipping - PostShoppingcartidLocker_v1:")
    public void sistema_processa_shopping_cart_shipping_post_shoppingcartid_locker_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Shipping_v1.POST_SHOPPING_SHIPPING_SHOPPINGCARTID_LOCKER)).getServiceResponse()
                , String.class
        );
    }
}
