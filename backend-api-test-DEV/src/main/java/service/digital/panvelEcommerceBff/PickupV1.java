package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface PickupV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_PICKUP_SUBSIDIARIES = "PanvelEcommerceBff-v1-GetPickupSubsidiaries";
    String PATCH_SELECT_ONE_STORE_TO_GET_PRODUCTS_IN_PERSON = "PanvelEcommerceBff-v1-PatchSelectOneStoreToGetProductsInPerson";
    String GET_ALL_PICKUP_SUBSIDIARIES = "PanvelEcommerceBff-v1-GetAllPickupSubsidiaries";

    Runnable getPickupSubsidiaries = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PICKUP_SUBSIDIARIES)).getServiceSpecs();
        String endpoint = "/v1/cart/pickup";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PICKUP_SUBSIDIARIES));
    };

    Runnable patchSelectOneStoreToGetProductsInPerson = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SELECT_ONE_STORE_TO_GET_PRODUCTS_IN_PERSON)).getServiceSpecs();
        String endpoint = "/v1/cart/pickup";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SELECT_ONE_STORE_TO_GET_PRODUCTS_IN_PERSON));
    };

    Runnable getAllPickupSubsidiaries = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ALL_PICKUP_SUBSIDIARIES)).getServiceSpecs();
        String endpoint = "/v1/cart/pickup/address";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ALL_PICKUP_SUBSIDIARIES));
    };

}
