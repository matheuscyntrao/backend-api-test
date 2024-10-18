package stepdef.digital.shoppingCart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1;
import service.digital.shoppingCart.ShoppingCart_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetShoppingcartShoppingShoppingcartidSteps {
    @Dado("possuo dados para ShoppingCart - Shopping - GetShoppinShoppingcartid path:")
    public void possuo_dados_para_shopping_cart_shopping_get_shoppin_shoppingcartid_path(Map<String, String> path) {
        BuilderRequest.path.accept(Util.rota.apply(ShoppingCart_v1.GET_SHOPPING), path);
    }

    @Quando("executo ShoppingCart - Shopping - GetShoppinShoppingcartid")
    public void executo_shopping_cart_shopping_get_shoppin_shoppingcartid() {
        ShoppingCart_v1.getShopping.run();
    }

    @Entao("sistema processa ShoppingCart - Shopping - GetShoppinShoppingcartid:")
    public void sistema_processa_shopping_cart_shopping_get_shoppin_shoppingcartid(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.GET_SHOPPING)).getServiceResponse()
                , ShoppingCartResponse_v1.class
        );
    }

    public void executo(Map<String, String> path){
        possuo_dados_para_shopping_cart_shopping_get_shoppin_shoppingcartid_path(path);
        executo_shopping_cart_shopping_get_shoppin_shoppingcartid();
    }
}
