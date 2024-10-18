package service.plataforma.paymentGateway;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Cardsv1 extends ServiceBase {

    String dominio = "/payment-gateway";
    String url = Util.uri.apply("payment-gateway-service") + dominio;

    String POST_CARDS_CARDS = "PaymentGateway-Cards-PostCardsCards";
    String GET_CARDS_CARDID = "PaymentGateway-Cards-GetCardsCardid";
    String DELETE_CARDS_CARDID = "PaymentGateway-Cards-DeleteCardsCardid";
    String GET_CARDS_CUSTOMER_CUSTOMERID = "PaymentGateway-Cards-GetCardsCustomerCustomerid";
    String DELETE_CARDS_REMOVE = "PaymentGateway-Cards-DeleteCardsRemove";

    Runnable postCards = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CARDS_CARDS)).getServiceSpecs();
        String endpoint = "/v1/cards";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CARDS_CARDS));
    };

    Runnable getCardsCardid = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CARDS_CARDID)).getServiceSpecs();
        String endpoint = "/v1/cards/{cardId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CARDS_CARDID));
    };

    Runnable deleteCardsCardid = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CARDS_CARDID)).getServiceSpecs();
        String endpoint = "/v1/cards/{cardId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CARDS_CARDID));
    };

    Runnable getCardsCustomersCustomerid = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CARDS_CUSTOMER_CUSTOMERID)).getServiceSpecs();
        String endpoint = "/v1/cards/customer/{customerId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CARDS_CUSTOMER_CUSTOMERID));
    };

    Runnable deleteCardsRemove = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CARDS_REMOVE)).getServiceSpecs();
        String endpoint = "/v1/cards/remove";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CARDS_REMOVE));
    };

}
