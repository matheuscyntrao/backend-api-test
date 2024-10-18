package service.bankAccount;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public interface BillControllerV1 extends ServiceBase {

    String dominio = "/bank-account";
    String url = Util.uri.apply("bank-account") + dominio;

    String GET_BILL_BY_TYPEABLELINE = "BankAccount-v1-GetBillByTypeableline";


        Runnable getBillByTypeableline = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_BILL_BY_TYPEABLELINE)).getServiceSpecs();
        String endpoint = "/v1/bills/{typeableline}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_BILL_BY_TYPEABLELINE));
    };
}
