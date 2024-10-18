package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface DeliveryV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_LIST_SHIPPING_METHODS_FOR_SHOPPING_CART_ITEMS = "PanvelEcommerceBff-v1-PatchListShippingMethodsForShoppingCartItems";
    String PATCH_SELECT_SHIPPING_BY_TYPE_AND_ROUTE_ID = "PanvelEcommerceBff-v1-PatchSelectShippingByTypeAndRouteId";

    Runnable patchListShippingMethodsForShoppingCartItems = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LIST_SHIPPING_METHODS_FOR_SHOPPING_CART_ITEMS)).getServiceSpecs();
        String endpoint = "/v1/cart/delivery";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LIST_SHIPPING_METHODS_FOR_SHOPPING_CART_ITEMS));
    };

    Runnable patchSelectShippingByTypeAndRouteId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SELECT_SHIPPING_BY_TYPE_AND_ROUTE_ID)).getServiceSpecs();
        String endpoint = "/v1/cart/delivery";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SELECT_SHIPPING_BY_TYPE_AND_ROUTE_ID));
    };

}
