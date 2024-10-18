package service.bankAccount;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface PaymentControllerV1 extends ServiceBase {

    String dominio = "/bank-account";
    String url = Util.uri.apply("bank-account") + dominio;

    String POST_INTERNAL_TRANSFER = "BankAccount-v1-PostInternalTransfer";

    Consumer<String> postInternalTransfer = (token) -> {
        PaymentControllerV1.loadTokenHeader.accept(token, POST_INTERNAL_TRANSFER);
        Cache.chamadas.get(Util.rota.apply(POST_INTERNAL_TRANSFER))
                .getServiceSpecs()
                .header
                .putIfAbsent("X-Device-Id", UUID.randomUUID().toString());

        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_INTERNAL_TRANSFER)).getServiceSpecs();
        String endpoint = "/v1/payment/internal";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_INTERNAL_TRANSFER));
    };

    BiConsumer<String, String> loadTokenHeader = (token, path) -> {
        Cache.chamadas.get(Util.rota.apply(path))
                .getServiceSpecs()
                .header
                .putIfAbsent("Authorization", token);
    };
}
