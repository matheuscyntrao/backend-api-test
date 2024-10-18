package service.bankAccount;

import utils.HmacUtils;
import utils.Util;
import utils.properties.LoginTokenProperties;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

import java.nio.charset.StandardCharsets;

public interface MateraAccountV1 extends ServiceBase {

    String url = "https://incubadora-mp-api-hml.matera.systems";

    String GET_MATERA_ACCOUNT_BY_ID = "Matera-v1-GetMateraAccountByID";

    Runnable getMateraAccountByID = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_MATERA_ACCOUNT_BY_ID)).getServiceSpecs();
        String endpoint = "/v1/accounts/{accountId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        specs.header.put("Transaction-Hash", HmacUtils.calcHmacSha256(LoginTokenProperties.secretKey.getBytes(StandardCharsets.UTF_8)
                , specs.path.get("accountId").getBytes(StandardCharsets.UTF_8)));
        specs.header.put("Api-Access-Key", LoginTokenProperties.apiKey);
        BaseRequest.get.accept(specs, Util.rota.apply(GET_MATERA_ACCOUNT_BY_ID));
    };
}
