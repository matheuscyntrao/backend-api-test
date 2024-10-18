package stepdef.digital.shoppingCart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shoppingCart.response.CustomerCardResponse_v1;
import service.digital.shoppingCart.Customer_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetShoppingCustomerCardsSteps {
    @Dado("possuo dados para ShoppingCart - Customer - GetCustomerCards_v1 path:")
    public void possuo_dados_para_shopping_cart_customer_get_customer_cards_v1_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Customer_v1.GET_SHOPPING_SHOPPINGCARTID_CUSTOMER_CARDS), dataTable);
    }

    @Quando("executo ShoppingCart - Customer - GetCustomerCards_v1")
    public void executo_shopping_cart_customer_get_customer_cards_v1() {
        Customer_v1.getShoppingShoppingcartidCustomerCards.run();
    }

    @Entao("sistema processa ShoppingCart - Customer - GetCustomerCards_v1:")
    public void sistema_processa_shopping_cart_customer_get_customer_cards_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Customer_v1.GET_SHOPPING_SHOPPINGCARTID_CUSTOMER_CARDS)).getServiceResponse()
                , CustomerCardResponse_v1[].class
        );
    }
}
