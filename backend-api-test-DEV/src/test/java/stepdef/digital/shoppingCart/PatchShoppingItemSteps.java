package stepdef.digital.shoppingCart;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.request.ShoppingCartItemRequest_v1;
import model.digital.shoppingCart.request.ShoppingCartItemRequestv1_Itens;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1;
import service.digital.shoppingCart.ShoppingCart_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import javax.ws.rs.core.UriBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class PatchShoppingItemSteps {
    static String ROTA = ShoppingCart_v1.PATCH_SHOPPING_SHOPPINGCARTID_ITEM;

    @Dado("possuo dados para ShoppingCart-ShoppingCart-Item:")
    public void possuo_dados_para_shopping_cart_shopping_cart_item(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), ShoppingCartItemRequest_v1.builder().items(Arrays.asList(CucumberUtils.getObjectBody(dataTable, ShoppingCartItemRequestv1_Itens[].class).clone())).build());
        BuilderRequest.path.accept(Util.rota.apply(ROTA), Map.of("shoppingCartId",
                Cache.valores.get(Util.rota.apply("CARRINHO"))
        ));
    }

    @Quando("executo ShoppingCart-ShoppingCart-Item")
    public void executo_shopping_cart_shopping_cart_item() {
        ShoppingCart_v1.pathShoppingShoppingcartidItem.run();
    }

    @Entao("sistema processa ShoppingCart-ShoppingCart-Item:")
    public void sistema_processa_shopping_cart_shopping_cart_item(io.cucumber.datatable.DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , ShoppingCartResponse_v1.class
        );
    }
}
