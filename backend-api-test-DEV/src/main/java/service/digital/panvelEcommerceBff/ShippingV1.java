package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ShippingV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_RETURN_AVAILABLE_SHIPMENTS = "PanvelEcommerceBff-v1-GetReturnAvailableShipments";
    String POST_ADD_SHIPPING_CART = "PanvelEcommerceBff-v1-PostAddShippingCart";
    String PUT_EDIT_SHIPMENT = "PanvelEcommerceBff-v1-PutEditShipment";
    String DELETE_SHIPMENT = "PanvelEcommerceBff-v1-DeleteShipment";
    String GET_RETURN_THE_AVAILABLE_SHIPMENTS = "PanvelEcommerceBff-v1-GetReturnTheAvailableShipments";

    Runnable getReturnAvailableShipments = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_RETURN_AVAILABLE_SHIPMENTS)).getServiceSpecs();
        String endpoint = "/v1/cart/shiping";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_RETURN_AVAILABLE_SHIPMENTS));
    };

    Runnable postAddShippingCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADD_SHIPPING_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/shiping";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADD_SHIPPING_CART));
    };

    Runnable putEditShipment = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_EDIT_SHIPMENT)).getServiceSpecs();
        String endpoint = "/v1/cart/shiping/{shippingId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_EDIT_SHIPMENT));
    };

    Runnable deleteShipment = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_SHIPMENT)).getServiceSpecs();
        String endpoint = "/v1/cart/shiping/{shippingId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_SHIPMENT));
    };

    Runnable getReturnTheAvailableShipments = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_RETURN_THE_AVAILABLE_SHIPMENTS)).getServiceSpecs();
        String endpoint = "/v1/cart/shiping/modality";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_RETURN_THE_AVAILABLE_SHIPMENTS));
    };


}
