package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface LockerV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_RETURN_LOCKERS_FROM_INFORMED_ADDRESS = "PanvelEcommerceBff-v1-GetReturnLockersFromInformedAddress";
    String POST_RESERVE_THE_LOCKER_WITH_SHOPPING_CART_ITEMS = "PanvelEcommerceBff-v1-PostReserveTheLockerWithShoppingCartItems";
    String DELETE_CART_LOCKER_RESERVE = "PanvelEcommerceBff-v1-DeleteCartLockerReserve";
    String GET_LOCKERS_FROM_INFORMED_ADDRESS = "PanvelEcommerceBff-v1-GetLockersFromInformedAddress";

    Runnable getReturnLockersFromInformedAddress = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_RETURN_LOCKERS_FROM_INFORMED_ADDRESS)).getServiceSpecs();
        String endpoint = "/v1/cart/locker";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_RETURN_LOCKERS_FROM_INFORMED_ADDRESS));
    };

    Runnable postReserveTheLockerWithShoppingCartItems = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_RESERVE_THE_LOCKER_WITH_SHOPPING_CART_ITEMS)).getServiceSpecs();
        String endpoint = "/v1/cart/locker";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_RESERVE_THE_LOCKER_WITH_SHOPPING_CART_ITEMS));
    };

    Runnable deleteCartLockerReserve = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CART_LOCKER_RESERVE)).getServiceSpecs();
        String endpoint = "/v1/cart/locker";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CART_LOCKER_RESERVE));
    };

    Runnable getLockersFromInformedAddress = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOCKERS_FROM_INFORMED_ADDRESS)).getServiceSpecs();
        String endpoint = "/v1/cart/locker/address";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOCKERS_FROM_INFORMED_ADDRESS));
    };

}
