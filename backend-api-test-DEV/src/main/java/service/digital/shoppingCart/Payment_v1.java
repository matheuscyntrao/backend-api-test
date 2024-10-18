package service.digital.shoppingCart;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Payment_v1 extends ServiceBase {

    String dominio = "/shopping-cart";
    String url = Util.uri.apply("shopping-cart-service") + dominio;

    String GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS = "ShoppingCart-v1-GetShoppingShoppingcartcodePayments";
    String DELETE_SHOPPING_SHOPPINGCARTCODE_PAYMENTS = "ShoppingCart-v1-DeleteShoppingShoppingcartcodePayments";
    String GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_PAYMENT_INSTALLMENTS_COVENANTCODE = "ShoppingCart-v1-GetShoppingShoppingcartcodePaymentsPaymentInstallmentsCovenantcode";
    String PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_BANKSLIP = "ShoppingCart-v1-PatchShoppingShoppingcartcodePaymentsBankslip";
    String PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CASH = "ShoppingCart-v1-PatchShoppingShoppingcartcodePaymentsCash";
    String GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_COVENANT = "ShoppingCart-v1-GetShoppingShoppingcartcodePaymentsCovenant";
    String PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_COVENANT = "ShoppingCart-v1-PatchShoppingShoppingcartcodePaymentsCovenant";
    String PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CREDIT = "ShoppingCart-v1-PatchShoppingShoppingcartcodePaymentsCredit";
    String PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_DEBIT = "ShoppingCart-v1-PatchShoppingShoppingcartcodePaymentsDebit";
    String PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_DEBIT_INSTALLMENT = "ShoppingCart-v1-PatchShoppingShoppingcartcodePaymentsDebitInstallment";
    String GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_POS = "ShoppingCart-v1-GetShoppingShoppingcartcodePaymentsPos";

    Runnable getShoppingShoppingcartcodePayments = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS));
    };

    Runnable deleteShoppingShoppingcartcodePayments= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_SHOPPING_SHOPPINGCARTCODE_PAYMENTS)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_SHOPPING_SHOPPINGCARTCODE_PAYMENTS));
    };

    Runnable getShoppingShoppingcartcodePaymentsPaymentInstallmentsCovenantcode= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_PAYMENT_INSTALLMENTS_COVENANTCODE)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/{payment}/installments/{covenantCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_PAYMENT_INSTALLMENTS_COVENANTCODE));
    };

    Runnable patchShoppingShoppingcartcodePaymentsBankslip= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_BANKSLIP)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/bankslip";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_BANKSLIP));
    };

    Runnable patchShoppingShoppingcartcodePaymentsCash= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CASH)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/cash";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CASH));
    };

    Runnable getShoppingShoppingcartcodePaymentsCovenant = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_COVENANT)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/covenant";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_COVENANT));
    };

    Runnable patchShoppingShoppingcartcodePaymentsCovenant= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_COVENANT)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/covenant";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_COVENANT));
    };

    Runnable patchShoppingShoppingcartcodePaymentsCredit = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CREDIT)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/credit";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_CREDIT));
    };

    Runnable patchShoppingShoppingcartcodePaymentsDebit= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_DEBIT)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/debit";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_DEBIT));
    };

    Runnable patchShoppingShoppingcartcodePaymentsDebitInstallment= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_DEBIT_INSTALLMENT)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/debit/installment";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_DEBIT_INSTALLMENT));
    };

    Runnable getShoppingShoppingcartcodePaymentsPos= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_POS)).getServiceSpecs();
        String endpoint = "/v1/shopping/{shoppingCartCode}/payments/pos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SHOPPING_SHOPPINGCARTCODE_PAYMENTS_POS));
    };
}
