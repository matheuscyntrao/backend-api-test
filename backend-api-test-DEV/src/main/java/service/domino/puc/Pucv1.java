package service.domino.puc;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pucv1 extends ServiceBase {

    String dominio = "/puc";
    String url = Util.uri.apply("puc-service") + dominio;

    String GET_WALLET_ITEMS_VALIDATION = "PucService-v1-GetWalletItemsValidation";
    String GET_CLIENTS = "PucService-v1-GetClients";
    String PUT_WALLET_ITEMS = "PucService-v1-PutWalletItems";

    Runnable getWalletItemsValidation = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_WALLET_ITEMS_VALIDATION)).getServiceSpecs();
        String endpoint = "/v1/wallets/items/validation";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_WALLET_ITEMS_VALIDATION));
    };
    Runnable getClients = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTS)).getServiceSpecs();
        String endpoint = "/v1/clients";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTS));
    };
    Runnable putWalletItems = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_WALLET_ITEMS)).getServiceSpecs();
        String endpoint = "/v1/wallets/items";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(PUT_WALLET_ITEMS));
    };

}
