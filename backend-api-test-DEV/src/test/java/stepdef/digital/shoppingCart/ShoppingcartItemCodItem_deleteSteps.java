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

import java.util.HashMap;
import java.util.Map;

public class ShoppingcartItemCodItem_deleteSteps {
    @Dado("que possuo dados para ShoppingCart - ShoppingCart - DeleteItemCodItem_v1 path")
    public void que_possuo_dados_para_shopping_cart_shopping_cart_delete_item_cod_item_v1_path() {
        BuilderRequest.path.accept(Util.rota.apply(ShoppingCart_v1.DELETE_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM), Map.of(
                "shoppingCartId", Cache.valores.get(Util.rota.apply("CARRINHO"))
                ,"itemId", Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class).getItems()[0].getCode()
        ));
    }

    public void que_possuo_dados_para_shopping_cart_shopping_cart_delete_item_cod_item_v1_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ShoppingCart_v1.DELETE_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM), dataTable);
    }

    @Quando("executo ShoppingCart - ShoppingCart - DeleteItemCodItem_v1")
    public void executo_shopping_cart_shopping_cart_delete_item_cod_item_v1() {
        ShoppingCart_v1.deleteShoppingShoppingCartidItemCoditem.run();
    }

    @Entao("sistema processa ShoppingCart - ShoppingCart - DeleteItemCodItem_v1:")
    public void sistema_processa_shopping_cart_shopping_cart_delete_item_cod_item_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.DELETE_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceResponse()
                , ShoppingCartResponse_v1.class
        );
    }

    public void deletoItemdaCarrinho(String item, String carrinho) {
        Map<String, String> path = new HashMap<>();
        path.put("shoppingCartId", carrinho);
        path.put("itemId", item);
        que_possuo_dados_para_shopping_cart_shopping_cart_delete_item_cod_item_v1_path(path);
        executo_shopping_cart_shopping_cart_delete_item_cod_item_v1();
    }
}
