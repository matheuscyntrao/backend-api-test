package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ShoppingCartV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_FIND_SHOPPING_CART_BY_ID = "PanvelEcommerceBff-v1-GetFindShoppingCartById";
    String PUT_CREATE_SHOPPING_CART = "PanvelEcommerceBff-v1-PutCreatingShoppingCart";
    String PATCH_CHANGE_SUBSIDIARY_IN_CART_BY_ZIPCODE = "PanvelEcommerceBff-v1-PatchChangeSubsidiaryInCartByZipcode";
    String POST_DO_ORDER = "PanvelEcommerceBff-v1-PostDoOrder";
    String POST_PRE_AUTHORIZATION = "PanvelEcommerceBff-v1-PostPreAuthorization";

    Runnable getFindShoppingCartById = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIND_SHOPPING_CART_BY_ID)).getServiceSpecs();
        String endpoint = "/v1/cart";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FIND_SHOPPING_CART_BY_ID));
    };

    Runnable putCreatingShoppingCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CREATE_SHOPPING_CART)).getServiceSpecs();
        String endpoint = "/v1/cart";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CREATE_SHOPPING_CART));
    };

    Runnable patchChangeSubsidiaryInCartByZipcode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_CHANGE_SUBSIDIARY_IN_CART_BY_ZIPCODE)).getServiceSpecs();
        String endpoint = "/v1/cart/{code}/zipcode/{zipCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_CHANGE_SUBSIDIARY_IN_CART_BY_ZIPCODE));
    };

    Runnable postDoOrder = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DO_ORDER)).getServiceSpecs();
        String endpoint = "/v1/cart/order";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DO_ORDER));
    };

    Runnable postPreAuthorization = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRE_AUTHORIZATION)).getServiceSpecs();
        String endpoint = "/v1/cart/pre-authorization";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRE_AUTHORIZATION));
    };

}
