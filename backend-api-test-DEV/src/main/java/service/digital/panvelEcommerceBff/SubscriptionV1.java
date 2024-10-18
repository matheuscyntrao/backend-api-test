package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface SubscriptionV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String PATCH_SUBSCRIBE_TO_A_CART_ITEM = "PanvelEcommerceBff-v1-PatchSubscribeToACartItem";
    String GET_LIST_SUBSCRIPTION_FREQUENCY = "PanvelEcommerceBff-v1-GetListSubscriptionFrequency";

    Runnable patchSubscribeToACartItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SUBSCRIBE_TO_A_CART_ITEM)).getServiceSpecs();
        String endpoint = "/v1/cart/item/subscription";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SUBSCRIBE_TO_A_CART_ITEM));
    };

    Runnable getListSubscriptionFrequency = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LIST_SUBSCRIPTION_FREQUENCY)).getServiceSpecs();
        String endpoint = "/v1/cart/subscription/frequency";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LIST_SUBSCRIPTION_FREQUENCY));
    };

}
