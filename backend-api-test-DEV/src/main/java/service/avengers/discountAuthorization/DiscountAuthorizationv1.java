package service.avengers.discountAuthorization;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface DiscountAuthorizationv1 extends ServiceBase {

    String dominio = "/discountauthorization";  //TODO: verificar depois
    String url = Util.uri.apply("discount-authorization-service") + dominio;

    String POST_ADMIN_JOB = "DiscountAuthorization-v1-PostAdminJob";
    String POST_ADMIN_CONFIGURATION = "DiscountAuthorization-v1-PostAdminConfiguration";
    String PUT_ADMIN_CONFIGURATION_STORE = "DiscountAuthorization-v1-PutAdminConfigurationStore";
    String GET_ADMIN_CONFIGURATION = "DiscountAuthorization-v1-GetAdminConfiguration";
    String POST_ADMIN_STORE_BALANCE = "DiscountAuthorization-v1-PostAdminStoreBalance";
    String PUT_ADMIN_STORE_BALANCE_STORE = "DiscountAuthorization-v1-PutAdminStoreBalanceStore";
    String POST_ADMIN_STORE_BALANCE_ADJUST_BALANCE_STORE = "DiscountAuthorization-v1-PostAdminStoreBalanceAdjustBalanceStore";
    String GET_ADMIN_STORE_BALANCE = "DiscountAuthorization-v1-GetAdminStoreBalance";
    String GET_ADMIN_HISTORICAL_STORE = "DiscountAuthorization-v1-GetAdminHistoricalStore";
    String GET_ADMIN_TRANSACTION = "DiscountAuthorization-v1-GetAdminTransaction";
    String GET_ADMIN_MOVEMENT_TYPE = "DiscountAuthorization-v1-GetAdminMovementType";
    String POST_STORE_BALANCE_DEBIT = "DiscountAuthorization-v1-PostStoreBalanceDebit";
    String PUT_STORE_BALANCE_DEBIT_CONFIRM = "DiscountAuthorization-v1-PutStoreBalanceDebitConfirm";
    String POST_STORE_BALANCE_CREDIT = "DiscountAuthorization-v1-PostStoreBalanceCredit";
    String GET_STORE_BALANCE_STORE = "DiscountAuthorization-v1-GetStoreBalanceStore";

    Runnable postAdminJob = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADMIN_JOB)).getServiceSpecs();
        String endpoint = "/v1/admin/job";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADMIN_JOB));
    };

    Runnable postadminConfiguration = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADMIN_CONFIGURATION)).getServiceSpecs();
        String endpoint = "/v1/admin/configuration";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADMIN_CONFIGURATION));
    };

    Runnable putAdminConfigurationStore = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_ADMIN_CONFIGURATION_STORE)).getServiceSpecs();
        String endpoint = "/v1/admin/configuration/{store}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_ADMIN_CONFIGURATION_STORE));
    };

    Runnable getAdminConfiguration = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ADMIN_CONFIGURATION)).getServiceSpecs();
        String endpoint = "/v1/admin/configuration";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ADMIN_CONFIGURATION));
    };

    Runnable postAdminStoreBalance = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADMIN_STORE_BALANCE)).getServiceSpecs();
        String endpoint = "/v1/admin/store-balance";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADMIN_STORE_BALANCE));
    };

    Runnable putAdminStoreBalanceStore = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_ADMIN_STORE_BALANCE_STORE)).getServiceSpecs();
        String endpoint = "/v1/admin/store-balance/{store}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_ADMIN_STORE_BALANCE_STORE));
    };

    Runnable postAdminStoreBalanceAdjustBalanceStore = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADMIN_STORE_BALANCE_ADJUST_BALANCE_STORE)).getServiceSpecs();
        String endpoint = "/v1/admin/store-balance/adjust-balance/{store}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADMIN_STORE_BALANCE_ADJUST_BALANCE_STORE));
    };

    Runnable getAdminStoreBalance = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ADMIN_STORE_BALANCE)).getServiceSpecs();
        String endpoint = "/v1/admin/store-balance";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ADMIN_STORE_BALANCE));
    };

    Runnable getAdminHistoricalStore = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ADMIN_HISTORICAL_STORE)).getServiceSpecs();
        String endpoint = "/v1/admin/historical/{store}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ADMIN_HISTORICAL_STORE));
    };

    Runnable getAdminTransaction = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ADMIN_TRANSACTION)).getServiceSpecs();
        String endpoint = "/v1/admin/transaction";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ADMIN_TRANSACTION));
    };

    Runnable getAdminMovementType = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ADMIN_MOVEMENT_TYPE)).getServiceSpecs();
        String endpoint = "/v1/admin/movement-type";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ADMIN_MOVEMENT_TYPE));
    };

    Runnable postStoreBalanceDebit = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_STORE_BALANCE_DEBIT)).getServiceSpecs();
        String endpoint = "/v1/store-balance/debit";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_STORE_BALANCE_DEBIT));
    };

    Runnable putStoreBalanceDebitConfig = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_STORE_BALANCE_DEBIT_CONFIRM)).getServiceSpecs();
        String endpoint = "/v1/store-balance/debit/confirm";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_STORE_BALANCE_DEBIT_CONFIRM));
    };

    Runnable postStoreBalanceCredit = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_STORE_BALANCE_CREDIT)).getServiceSpecs();
        String endpoint = "/v1/store-balance/credit";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_STORE_BALANCE_CREDIT));
    };

    Runnable getStoreBalanceStore = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_STORE_BALANCE_STORE)).getServiceSpecs();
        String endpoint = "/v1/store-balance/{store}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_STORE_BALANCE_STORE));
    };
}
