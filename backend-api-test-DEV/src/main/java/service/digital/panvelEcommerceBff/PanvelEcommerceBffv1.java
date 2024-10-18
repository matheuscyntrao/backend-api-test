package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface PanvelEcommerceBffv1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String POST_ADD_ITEMS_TO_CART = "PanvelEcommerceBff-v1-PostAddItemsToCart";
    String DELETE_ITEMS_FROM_CART = "PanvelEcommerceBff-v1-DeleteItemsFromCart";
    String PATCH_ITEMS_SIZE = "PanvelEcommerceBff-v1-PatchItemsSize";
    String GET_FREQUENCY = "PanvelEcommerceBff-v1-GetSubscriptionFrequency";
    String PATCH_CONVENTION_DISCOUNT = "PanvelEcommerceBff-v1-PatchConventionInCash";
    String PATCH_COUPON_DISCOUNT = "PanvelEcoomerceBff-v1-PatchCouponDiscount";
    String GET_ITEMS_TAGS = "PanvelEcommerceBff-v1-GetTags";

    Runnable postAddItemsToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADD_ITEMS_TO_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADD_ITEMS_TO_CART));
    };

    Runnable deleteItemsToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_ITEMS_FROM_CART)).getServiceSpecs();
        String endpoint = "/panvel-ecommerce-bff/v1/cart/item/{panvelCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_ITEMS_FROM_CART));
    };

    Runnable patchItemsSize = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ITEMS_SIZE)).getServiceSpecs();
        String endpoint = "/panvel-ecommerce-bff/v1/cart/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ITEMS_SIZE));
    };

    Runnable getSubscriptionFrequency = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FREQUENCY)).getServiceSpecs();
        String endpoint = "/panvel-ecommerce-bff/v1/subscription/frequency";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FREQUENCY));
    };

    Runnable patchConventionInCash = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_CONVENTION_DISCOUNT)).getServiceSpecs();
        String endpoint = "/panvel-ecommerce-bff/v1/cart/convenio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_CONVENTION_DISCOUNT));
    };

    Runnable patchCouponInCash = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_COUPON_DISCOUNT)).getServiceSpecs();
        String endpoint = "/panvel-ecommerce-bff/v1/cart/cupon/{cuponId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_COUPON_DISCOUNT));
    };

    Runnable getItemsTags = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEMS_TAGS)).getServiceSpecs();
        String endpoint = "/panvel-ecommerce-bff/v1/item/{panvelCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEMS_TAGS));
    };

}
