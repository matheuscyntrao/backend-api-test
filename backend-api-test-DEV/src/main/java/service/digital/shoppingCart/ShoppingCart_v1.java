package service.digital.shoppingCart;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ShoppingCart_v1 extends ServiceBase {

    String dominio = "/shopping-cart";
    String url = Util.uri.apply("shopping-cart-service") + dominio;

    String PUT_SHOPPING = "ShoppingCart-v1-PutShopping";
    String GET_SHOPPING = "ShoppingCart-v1-GetShoppingcartid";
    String PATCH_SHOPPING_SHOPPINGCARTID_CONVENIO = "ShoppingCart-v1-PatchShoppingShoppingcartidConvenio";
    String PATCH_SHOPPING_SHOPPINGCARTID_CUPOM_CUPOMID = "ShoppingCart-v1-PatchShoppingShoppingcartidCupomCupomid";
    String PATCH_SHOPPING_SHOPPINGCARTID_CUSTOMER_CUSTOMERCODE = "ShoppingCart-v1-PatchShoppingShoppingcartidCustomerCustomercode";
    String PATCH_SHOPPING_SHOPPINGCARTID_ITEM = "ShoppingCart-v1-PatchShoppingShoppingcartidItem";
    String PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM = "ShoppingCart-v1-PatchShoppingShoppingcartidItemCoditem";
    String DELETE_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM = "ShoppingCart-v1-DeleteShoppingShoppingcartidItemCoditem";
    String PATCH_SHOPPING_SHOPPINGCARTID_PRESCRIPTION = "ShoppingCart-v1-PatchShoppingShoppingcartidPrescription";
    String POST_SHOPPING_ORDER_SHOPPINGCARTID = "ShoppingCart-v1-PostShoppingOrderShoppingcartid";
    String PATCH_DIGITAL_PRESCRIPTION = "ShoppingCart-v1-PatchShoppingDigitalPrescription";

    Runnable putShopping = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_SHOPPING)).getServiceSpecs();
        String endpoint = "/v1/shopping";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_SHOPPING));
    };

    Runnable getShopping = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING));
    };

    Runnable patchShoppingShoppingcartidConvenio= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_CONVENIO)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/convenio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_CONVENIO));
    };

    Runnable patchShoppingShoppingcartidCupomCupomid= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_CUPOM_CUPOMID)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/cupom/{cupomId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_CUPOM_CUPOMID));
    };

    Runnable PatchShoppingShoppingcartidCustomerCustomercode= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_CUSTOMER_CUSTOMERCODE)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/customer/{customerCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_CUSTOMER_CUSTOMERCODE));
    };

    Runnable pathShoppingShoppingcartidItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_ITEM)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_ITEM));
    };

    Runnable pathShoppingShoppingcartidItemCoditem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/item/{code}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM));
    };

    Runnable deleteShoppingShoppingCartidItemCoditem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/item/{itemId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_SHOPPING_SHOPPINGCARTID_ITEM_CODITEM));
    };

    Runnable patchShoppingShoppingcartidPrescription = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_PRESCRIPTION)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/prescription";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_PRESCRIPTION));
    };

    Runnable postShoppingOrderShoppingcartid= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SHOPPING_ORDER_SHOPPINGCARTID)).getServiceSpecs();
        String endpoint = "/v1/shopping/order/{shoppingCartId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SHOPPING_ORDER_SHOPPINGCARTID));
    };

    Runnable patchDigitalPrescription= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_DIGITAL_PRESCRIPTION)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/digitalPrescription";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_DIGITAL_PRESCRIPTION));
    };
}
