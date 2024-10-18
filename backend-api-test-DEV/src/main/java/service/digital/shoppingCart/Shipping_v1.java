package service.digital.shoppingCart;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Shipping_v1 extends ServiceBase {

    String dominio = "/shopping-cart";
    String url = Util.uri.apply("shopping-cart-service") + dominio;

    String PATCH_SHOPPING_SHOPPINGCARTID_DELIVERY_DETAILS = "ShoppingCart-v1-PatchShoppingShoppcartidDeliveryDetails";
    String GET_SHOPPING_SHIPPING = "ShoppingCart-v1-GetShoppingShipping";
    String POST_SHOPPING_SHIPPING = "ShoppingCart-v1-PostShoppingShipping";
    String PUT_SHOPPING_SHIPPING_SHIPPINGID = "ShoppingCart-v1-PutShoppingShippingShippingid";
    String DELETE_SHOPPING_SHIPPING_SHIPPINGID = "ShoppingCart-v1-DeleteShoppingShippingShippingid";
    String DELETE_SHOPPING_SHIPPING_SHOPPINGCARTCODE_LOCKER = "ShoppingCart-v1-DeleteShoppingShippingShoppingcartcodeLocker";
    String PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY = "ShoppingCart-v1-PatchShoppingShippingShoppingcartidDelivery";
    String GET_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY = "ShoppingCart-v1-GetShoppingShippingShoppingcartidDelivery";
    String POST_SHOPPING_SHIPPING_SHOPPINGCARTID_LOCKER = "ShoppingCart-v1-PostShoppingShippingShoppingcartidLocker";
    String GET_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP = "ShoppingCart-v1-GetShoppingShippingShoppingcartidPickup";
    String PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP = "ShoppingCart-v1-PatchShoppingShippingShoppingcartidPickup";
    String GET_SHOPPING_SHIPPING_LOCKER = "ShoppingCart-v1-GetShoppingShippingLocker";

    Runnable patchShoppingshoppingcartidDeliveryDetails = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_DELIVERY_DETAILS)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartId}/delivery/details";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTID_DELIVERY_DETAILS));
    };

    Runnable getShoppingShipping = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHIPPING)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHIPPING));
    };

    Runnable postShoppingShipping = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SHOPPING_SHIPPING)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SHOPPING_SHIPPING));
    };

    Runnable putShoppingShippingShippingid = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_SHOPPING_SHIPPING_SHIPPINGID)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shippingId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_SHOPPING_SHIPPING_SHIPPINGID));
    };

    Runnable deleteShoppingShippingShippingid = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_SHOPPING_SHIPPING_SHIPPINGID)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shippingId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_SHOPPING_SHIPPING_SHIPPINGID));
    };

    Runnable deleteShoppingShippingShoppingcartcodeLocker = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_SHOPPING_SHIPPING_SHOPPINGCARTCODE_LOCKER)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shoppingCartCode}/locker";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_SHOPPING_SHIPPING_SHOPPINGCARTCODE_LOCKER));
    };

    Runnable patchShoppingShippingShoppingcartidDelivery = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shoppingCartId}/delivery";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY));
    };

    Runnable getShoppingShippingShoppingcartidDellivery = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shoppingCartId}/delivery/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHIPPING_SHOPPINGCARTID_DELIVERY));
    };

    Runnable postShoppingShippingShoppingcartidLocker = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SHOPPING_SHIPPING_SHOPPINGCARTID_LOCKER)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shoppingCartId}/locker";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SHOPPING_SHIPPING_SHOPPINGCARTID_LOCKER));
    };

    Runnable getShoppingShippingShoppingcartidPickup = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shoppingCartId}/pickup";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP));
    };

    Runnable patchShoppingShippingShoppingcartidPickup = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/{shoppingCartId}/pickup";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHIPPING_SHOPPINGCARTID_PICKUP));
    };

    Runnable getShoppingShippingLocker = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHIPPING_LOCKER)).getServiceSpecs();
        String endpoint = "/v1/shopping/shipping/locker";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHIPPING_LOCKER));
    };
}
