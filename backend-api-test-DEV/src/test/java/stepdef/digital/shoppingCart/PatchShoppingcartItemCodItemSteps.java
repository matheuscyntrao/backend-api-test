package stepdef.digital.shoppingCart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1_Item;
import org.junit.Assert;
import service.digital.shoppingCart.ShoppingCart_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.*;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PatchShoppingcartItemCodItemSteps {
    @Dado("que possuo dados para ShoppingCart - ShoppingCart - PatchItemCodItem_v1 path:")
    public void que_possuo_dados_para_shopping_cart_shopping_cart_patch_item_cod_item_v1_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM), dataTable);
    }

    @Dado("executo ShoppingCart - ShoppingCart - PatchItemCodItem_v1 path {string}")
    public void executo_shopping_cart_shopping_cart_patch_item_cod_item_v1_path( String item) {
        BuilderRequest.path.accept(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM),
                Map.of("shoppingCartId", Cache.valores.get(Util.rota.apply("CARRINHO"))
                        , "code", item)
        );
        executo_shopping_cart_shopping_cart_patch_item_cod_item_v1();
    }

    @Quando("executo ShoppingCart - ShoppingCart - PatchItemCodItem_v1")
    public void executo_shopping_cart_shopping_cart_patch_item_cod_item_v1() {
        ShoppingCart_v1.pathShoppingShoppingcartidItemCoditem.run();
    }

    @Entao("sistema processa ShoppingCart - ShoppingCart - PatchItemCodItem_v1:")
    public void sistema_processa_shopping_cart_shopping_cart_patch_item_cod_item_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceResponse()
                , ShoppingCartResponse_v1.class
        );
    }

    @Entao("valido ShoppingCart - ShoppingCart - PatchItemCodItem_v1")
    public void valido_shopping_cart_shopping_cart_patch_item_cod_item_v1() {
        Map<String, String> input = Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceSpecs().path;
        ShoppingCartResponse_v1 response_v1 = Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class);

        Optional<ShoppingCartResponse_v1_Item> item = Arrays.stream(response_v1.getItems()).filter(
                itens -> itens.getPanvelCode().toString().equals(input.get("codItem"))
        ).findFirst();

        Assert.assertNotNull(item);
    }

    @After("@hookShoppingCartControllerPatchItemCodItem_v1")
    public void delete() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceResponse().getStatusCode() == 200, () -> {
            ShoppingCartResponse_v1 response_v1 = Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class);
            Arrays.stream(response_v1.getItems()).forEach(item -> {
                new ShoppingcartItemCodItem_deleteSteps().deletoItemdaCarrinho(item.getCode(), response_v1.getShoppingCartId());
            });
        });
    }

    public void adicionoItens(List<Map<String, String>> itens, String shoppingCartId) {
        itens.forEach(t -> {
            Map<String, String> path = new HashMap<>();
            path.put("shoppingCartId", shoppingCartId);
            path.put("code", t.get("code"));
            que_possuo_dados_para_shopping_cart_shopping_cart_patch_item_cod_item_v1_path(path);
            executo_shopping_cart_shopping_cart_patch_item_cod_item_v1();
        });
    }
}
