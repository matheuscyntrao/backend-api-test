package service.timeB.phw31tst;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Phw31tst extends ServiceBase {

    String url = "http://phw031tst.panvel.com.br:8080";
    String POST_VENDA = "MarketplaceSeller-v1-PostVenda";
    String PATCH_VENDA = "MarketplaceSeller-v1-PatchVenda";

    Runnable postVenda = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_VENDA)).getServiceSpecs();
        String endpoint = "/venda";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_VENDA));
    };

    Runnable patchVenda = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_VENDA)).getServiceSpecs();
        String endpoint = "/venda/codigo-documento-saida/{code}/filial/31";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_VENDA));
    };
}
