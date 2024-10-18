package service.plataforma.paymentGateway;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Paymentsv1 extends ServiceBase {

    String dominio = "/payment-gateway";
    String url = Util.uri.apply("payment-gateway-service") + dominio;

    String POST_PAYMENTS_BILLET = "PaymentGateway-Payments-PaymentsBillet";
    String DELETE_PAYMENTS_CANCEL_NIT = "PaymentGateway-Payments-PaymentsCancelNit";
    String PATCH_PAYMENTS_CONFIRM_NIT = "PaymentGateway-Payments-PaymentsConfirmNit";
    String GET_PAYMENTS_FILIAL_FILIAL_ORDER_EXTERNALORDERID = "PaymentGateway-Payments-PaymentsFilialOrderExternalOrderid";
    String POST_PAYMENTS_HASH = "PaymentGateway-Payments-PaymentsHash";
    String GET_PAYMENTS_NIT_NIT = "PaymentGateway-Payments-PaymentsNitNit";
    String POST_PAYMENTS_VERIFYCARD = "PaymentGateway-Payments-PaymentsVerifycard";
    String POST_KONDUTO = "PaymentGateway-Payments-PostKonduto";
    String POST_CLEARSALE = "PaymentGateway-Payments-PostClearSale";

    Runnable postCards = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PAYMENTS_BILLET)).getServiceSpecs();
        String endpoint = "/v1/payments/billet";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PAYMENTS_BILLET));
    };

    Runnable deletePaymentsCancelNit = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_PAYMENTS_CANCEL_NIT)).getServiceSpecs();
        String endpoint = "/v1/payments/cancel/{nit}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_PAYMENTS_CANCEL_NIT));
    };

    Runnable patchPaymentsConfirmNit = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_PAYMENTS_CONFIRM_NIT)).getServiceSpecs();
        String endpoint = "/v1/payments/confirm/{nit}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_PAYMENTS_CONFIRM_NIT));
    };

    Runnable getPaymentsFilialOrderExternalorderid = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAYMENTS_FILIAL_FILIAL_ORDER_EXTERNALORDERID)).getServiceSpecs();
        String endpoint = "/v1/payments/filial/{filial}/order/{externalOrderId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAYMENTS_FILIAL_FILIAL_ORDER_EXTERNALORDERID));
    };

    Runnable postPaymentsHash = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PAYMENTS_HASH)).getServiceSpecs();
        String endpoint = "/v1/payments/hash";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PAYMENTS_HASH));
    };

    Runnable getPaymentsNitNit = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAYMENTS_NIT_NIT)).getServiceSpecs();
        String endpoint = "/v1/payments/nit/{nit}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAYMENTS_NIT_NIT));
    };

    Runnable postPaymentsVerifycard = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PAYMENTS_VERIFYCARD)).getServiceSpecs();
        String endpoint = "/v1/payments/verify-card";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PAYMENTS_VERIFYCARD));
    };

    Runnable postKonduto = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_KONDUTO)).getServiceSpecs();
        String endpoint = "/v1/konduto";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_KONDUTO));
    };

    Runnable postClearSale = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLEARSALE)).getServiceSpecs();
        String endpoint = "/v1/clearsale";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLEARSALE));
    };
}
