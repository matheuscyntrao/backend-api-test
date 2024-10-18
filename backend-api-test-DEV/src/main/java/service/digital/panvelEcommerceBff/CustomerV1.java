package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CustomerV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_SEARCH_CUSTOMER_BY_SHOPPING_CART_CODE = "PanvelEcommerceBff-v1-GetSearchCustomerByShoppingCartCode";
    String PATCH_ADD_CUSTOMER_TO_CART = "PanvelEcommerceBff-v1-PatchAddCustomerToCart";
    String GET_CUSTOMER_CARDS = "PanvelEcommerceBff-v1-GetCustomerCards";
    String PATCH_SET_ADDRESS_AND_PHONE_TO_SHIPPING = "PanvelEcommerceBff-v1-PatchSetAddressAndPhoneToShipping";

    Runnable getSearchCustomerByShoppingCartCode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SEARCH_CUSTOMER_BY_SHOPPING_CART_CODE)).getServiceSpecs();
        String endpoint = "/v1/cart/customer";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SEARCH_CUSTOMER_BY_SHOPPING_CART_CODE));
    };

    Runnable patchAddCustomerToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ADD_CUSTOMER_TO_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/customer";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ADD_CUSTOMER_TO_CART));
    };

    Runnable getCustomerCards = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CUSTOMER_CARDS)).getServiceSpecs();
        String endpoint = "/v1/cart/customer/cards";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CUSTOMER_CARDS));
    };

    Runnable patchSetAddressAndPhoneToShipping = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SET_ADDRESS_AND_PHONE_TO_SHIPPING)).getServiceSpecs();
        String endpoint = "/v1/cart/customer/shipping/details";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SET_ADDRESS_AND_PHONE_TO_SHIPPING));
    };

}
