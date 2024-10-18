package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Prescription extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String GET_PRESCIPTION_MODEL_FOR_GIVEN_ITENS = "PanvelEcommerceBff-v1-GetPrescriptionModelForGivenItens";
    String POST_VALIDATE_GIVEN_PARAMETERS_AND_CREATE_PRESCRIPTION_ON_DB = "PanvelEcommerceBff-v1-PostValidadeGivenParemetersAndCreatePrescriptionOnDatabase";

    Runnable getPrescriptionModelForGivenItens = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PRESCIPTION_MODEL_FOR_GIVEN_ITENS)).getServiceSpecs();
        String endpoint = "/v1/cart/prescription";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PRESCIPTION_MODEL_FOR_GIVEN_ITENS));
    };

    Runnable postValidadeGivenParemetersAndCreatePrescriptionOnDatabase = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_VALIDATE_GIVEN_PARAMETERS_AND_CREATE_PRESCRIPTION_ON_DB)).getServiceSpecs();
        String endpoint = "/v1/cart/prescription";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_VALIDATE_GIVEN_PARAMETERS_AND_CREATE_PRESCRIPTION_ON_DB));
    };

}
