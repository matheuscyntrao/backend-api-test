package service.bankAccount;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface AccountControllerV1 extends ServiceBase {

    String dominio = "/bank-account";
    String url = Util.uri.apply("bank-account") + dominio;

    String POST_CREATE_ACCOUNT = "BankAccount-v1-PostCreateAccount";
    String GET_ACCOUNT_BY_CPF = "BankAccount-v1-GetAccountByCpf";
    String PUT_ACCOUNT_UPDATE = "BankAccount-v1-PutAccountUpdate";
    String DELETE_ACCOUNT_BY_CPF = "BankAccount-v1-DeleteAccountByCpf";


    Consumer<String> postCreateAccount = (token) -> {
        AccountControllerV1.loadTokenHeader.accept(token, POST_CREATE_ACCOUNT);
        Cache.chamadas.get(Util.rota.apply(POST_CREATE_ACCOUNT))
                .getServiceSpecs()
                .header
                .putIfAbsent("X-Device-Id", UUID.randomUUID().toString());

        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CREATE_ACCOUNT)).getServiceSpecs();
        String endpoint = "/v1/account";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CREATE_ACCOUNT));
    };

    Consumer<String> getAccountByCpf = (token) -> {
        AccountControllerV1.loadTokenHeader.accept(token, GET_ACCOUNT_BY_CPF);
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ACCOUNT_BY_CPF)).getServiceSpecs();
        String endpoint = "/v1/account/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ACCOUNT_BY_CPF));
    };

    Consumer<String>  putAccountUpdate = (token) -> {
        AccountControllerV1.loadTokenHeader.accept(token, PUT_ACCOUNT_UPDATE);
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_ACCOUNT_UPDATE)).getServiceSpecs();
        String endpoint = "/v1/account/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_ACCOUNT_UPDATE));
    };

    Consumer<String> deleteAccountByCpf = (token) -> {
        AccountControllerV1.loadTokenHeader.accept(token, DELETE_ACCOUNT_BY_CPF);
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_ACCOUNT_BY_CPF)).getServiceSpecs();
        String endpoint = "/v1/account/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_ACCOUNT_BY_CPF));
    };

    BiConsumer<String, String> loadTokenHeader = (token, path) -> {
        Cache.chamadas.get(Util.rota.apply(path))
                .getServiceSpecs()
                .header
                .putIfAbsent("Authorization", token);
    };
}
