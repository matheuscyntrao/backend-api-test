package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface PaymentV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_AVAILABLE_PAYMENTS_SHOPPING_CART = "PanvelEcommerceBff-v1-GetAvailablePaymentsShoppingCart";
    String DELETE_PAYMENTS_FROM_SHOPPING_CART = "PanvelEcommerceBff-v1-DeletePaymentsFromShoppingCart";
    String GET_PAYMENT_CONDITIONS_BY_COVENANT_CODE = "PanvelEcommerceBff-v1-GetPaymentConditionsByCovenantCode";
    String PATCH_ADD_CREDIT_PAYMENT_TO_CART = "PanvelEcommerceBff-v1-PatchAddCreditPaymentToCart";
    String PATCH_ADD_DEBIT_PAYMENT_TO_CART = "PanvelEcommerceBff-v1-PatchAddDebitPaymentToCart";
    String PATCH_ADD_INSTALLMENT_DEBIT_PAYMENT_TO_CART = "PanvelEcommerceBff-v1-PatchAddInstallmentDebitPaymentToCart";
    String GET_LIST_POS_PAYMENTS = "PanvelEcommerceBff-v1-GetListPOSPayments";

    Runnable getAvailablePaymentsShoppingCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_AVAILABLE_PAYMENTS_SHOPPING_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/payment";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_AVAILABLE_PAYMENTS_SHOPPING_CART));
    };

    Runnable deletePaymentsFromShoppingCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_PAYMENTS_FROM_SHOPPING_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/payment";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_PAYMENTS_FROM_SHOPPING_CART));
    };

    Runnable getPaymentConditionsByCovenantCode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAYMENT_CONDITIONS_BY_COVENANT_CODE)).getServiceSpecs();
        String endpoint = "/v1/cart/payment/{payment}/installments/{covenantCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAYMENT_CONDITIONS_BY_COVENANT_CODE));
    };

    Runnable patchAddCreditPaymentToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ADD_CREDIT_PAYMENT_TO_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/payment/credit";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ADD_CREDIT_PAYMENT_TO_CART));
    };

    Runnable patchAddDebitPaymentToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ADD_DEBIT_PAYMENT_TO_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/payment/debit";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ADD_DEBIT_PAYMENT_TO_CART));
    };

    Runnable patchAddInstallmentDebitPaymentToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ADD_INSTALLMENT_DEBIT_PAYMENT_TO_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/payment/debit/installment";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ADD_INSTALLMENT_DEBIT_PAYMENT_TO_CART));
    };

    Runnable getListPOSPayments = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LIST_POS_PAYMENTS)).getServiceSpecs();
        String endpoint = "/v1/cart/payment/pos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LIST_POS_PAYMENTS));
    };

}
