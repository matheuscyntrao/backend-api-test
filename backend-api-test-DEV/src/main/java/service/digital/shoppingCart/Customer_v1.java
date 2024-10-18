package service.digital.shoppingCart;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Customer_v1 extends ServiceBase {

    String dominio = "/shopping-cart";
    String url = Util.uri.apply("shopping-cart-service") + dominio;

    String GET_SHOPPING_SHOPPINGCARTID_CUSTOMER = "ShoppingCart-v1-GetShoppingShoppingcartidCustomer";
    String GET_SHOPPING_SHOPPINGCARTID_CUSTOMER_CARDS = "ShoppingCart-v1-GetShoppingShoppingcartidCustomerCards";

    Runnable getShoppingShoppingcartidCustomer = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHOPPINGCARTID_CUSTOMER)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/customer";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHOPPINGCARTID_CUSTOMER));
    };

    Runnable getShoppingShoppingcartidCustomerCards = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHOPPINGCARTID_CUSTOMER_CARDS)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/customer/cards";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHOPPINGCARTID_CUSTOMER_CARDS));
    };

}
