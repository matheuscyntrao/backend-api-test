package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ConvenioV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String PATCH_ADD_CONVENIO_TO_CART = "PanvelEcommerceBff-v1-PatchAddConvenioToCart";

    Runnable patchAddConvenioToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ADD_CONVENIO_TO_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/convenio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ADD_CONVENIO_TO_CART));
    };

}
