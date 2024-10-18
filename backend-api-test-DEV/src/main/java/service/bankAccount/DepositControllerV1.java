package service.bankAccount;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface DepositControllerV1 extends ServiceBase {

    String dominio = "/bank-account";
    String url = Util.uri.apply("bank-account") + dominio;

    String POST_DEPOSIT_BILL = "BankAccount-v1-PostDepositBill";


    Consumer<String> postDepositBill = (token) -> {
        DepositControllerV1.loadTokenHeader.accept(token, POST_DEPOSIT_BILL);
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DEPOSIT_BILL)).getServiceSpecs();
        String endpoint = "/v1/deposit";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DEPOSIT_BILL));
    };

    BiConsumer<String, String> loadTokenHeader = (token, path) -> {
        Cache.chamadas.get(Util.rota.apply(path))
                .getServiceSpecs()
                .header
                .putIfAbsent("Authorization", token);
    };
}
