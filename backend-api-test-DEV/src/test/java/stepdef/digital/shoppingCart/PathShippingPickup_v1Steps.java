package stepdef.digital.shoppingCart;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.request.PatchShippingPickupRequest_v1;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1;
import service.digital.shoppingCart.Shipping_v1;
import service.digital.shoppingCart.ShoppingCart_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.Map;

public class PathShippingPickup_v1Steps {
    @Dado("possuo dados para ShoppingCart - Shipping - PatchPickup_v1:")
    public void possuo_dados_para_shopping_cart_shipping_patch_pickup_v1(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Shipping_v1.PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP), CucumberUtils.getObjectBody(dataTable, PatchShippingPickupRequest_v1.class));
        String shoppingCartId = Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PUT_SHOPPING)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class).getShoppingCartId();
        Map<String, String> path = Map.of("shoppingCartId", shoppingCartId);
        BuilderRequest.path.accept(Util.rota.apply(Shipping_v1.PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP), path);
    }

    @Quando("executo ShoppingCart - Shipping - PatchPickup_v1")
    public void executo_shopping_cart_shipping_patch_pickup_v1() {
        Shipping_v1.patchShoppingShippingShoppingcartidPickup.run();
    }

    @Entao("sistema processa ShoppingCart - Shipping - PatchPickup_v1:")
    public void sistema_processa_shopping_cart_shipping_patch_pickup_v1(DataTable dataTable) throws Exception {
        ShoppingCartResponse_v1 teste = Cache.chamadas.get(Util.rota.apply(Shipping_v1.PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class);

        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Shipping_v1.PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP)).getServiceResponse()
                , ShoppingCartResponse_v1.class
        );
    }

    public void executo(PatchShippingPickupRequest_v1 body, String shoppingCartId) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Shipping_v1.PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP), body);
        BuilderRequest.path.accept(Util.rota.apply(Shipping_v1.PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP), Map.of("shoppingCartId", shoppingCartId));
        executo_shopping_cart_shipping_patch_pickup_v1();
    }

}
