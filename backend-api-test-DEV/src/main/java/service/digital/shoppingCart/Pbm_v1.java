package service.digital.shoppingCart;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pbm_v1 extends ServiceBase {

    String dominio = "/shopping-cart";
    String url = Util.uri.apply("shopping-cart-service") + dominio;

    String POST_PBM_AUTORIZACAO_SHOPPINGCARTID = "ShoppingCart-v1-PostPbmAutorizacaoShoppingcartid";

    Runnable postPbmAutorizacaoShoppingcartid= () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PBM_AUTORIZACAO_SHOPPINGCARTID)).getServiceSpecs();
        String endpoint = "/v1/pbm/autorizacao/{shoppingCartId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PBM_AUTORIZACAO_SHOPPINGCARTID));
    };
}
