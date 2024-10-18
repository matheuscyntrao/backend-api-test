package service.bankAccount;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface BalanceControllerV1 extends ServiceBase {

    String dominio = "/bank-account";
    String url = Util.uri.apply("bank-account") + dominio;


    String PUT_BALANCE_LOCK = "BankAccount-v1-PutBalanceLock";
    String PUT_BALANCE_UNLOCK = "BankAccount-v1-PutBalanceUnlock";
    String GET_BALANCE_BY_CPF = "BankAccount-v1-GetBalanceByCpf";

    Consumer<String> getBalanceByCpf = (token) -> {
        BalanceControllerV1.loadTokenHeader.accept(token, GET_BALANCE_BY_CPF);
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_BALANCE_BY_CPF)).getServiceSpecs();
        String endpoint = "/v1/balance/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_BALANCE_BY_CPF));
    };

    Consumer<String>  putBalanceLock = (token) -> {
        BalanceControllerV1.loadTokenHeader.accept(token, PUT_BALANCE_LOCK);
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_BALANCE_LOCK)).getServiceSpecs();
        String endpoint = "/v1/balance/lock";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_BALANCE_LOCK));
    };

    Consumer<String>  putBalanceUnlock = (token) -> {
        BalanceControllerV1.loadTokenHeader.accept(token, PUT_BALANCE_UNLOCK);
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_BALANCE_UNLOCK)).getServiceSpecs();
        String endpoint = "/v1/balance/unlock";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_BALANCE_UNLOCK));
    };

    BiConsumer<String, String> loadTokenHeader = (token, path) -> {
        Cache.chamadas.get(Util.rota.apply(path))
                .getServiceSpecs()
                .header
                .putIfAbsent("Authorization", token);
    };
}
