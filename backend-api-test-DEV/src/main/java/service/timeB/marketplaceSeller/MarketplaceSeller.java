package service.timeB.marketplaceSeller;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface MarketplaceSeller extends ServiceBase {

    String dominio = "/marketplace-seller/v1";
    //String url = Util.uri.apply("marketplace-seller") + dominio;
    String url = "http://localhost:8080" + dominio;

    String POST_FILIAIS = "MarketplaceSeller-v1-PostFiliais";
    String POST_TOKEN = "MarketplaceSeller-v1-PostToken";
    String POST_PRODUTOS = "MarketplaceSeller-v1-PostProdutos";
    String POST_DELETE_PRODUTOS_SKYHUB = "MarketplaceSeller-v1-PostDeleteProdutos";
    String POST_API_FRETES = "MarketplaceSeller-v1-PostAPIFretes";
    String POST_RAPPI_ORDER = "MarketplaceSeller-v1-PostRappiOrder";
    String POST_IFOOD_TOKEN = "Ifood-v1-Bearer Token Validation";

    Runnable postFiliais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FILIAIS)).getServiceSpecs();
        String endpoint = "/skyhub/stores";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FILIAIS));
    };

    Runnable postToken = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_TOKEN)).getServiceSpecs();
        String endpoint = "/skyhub/authentication";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_TOKEN));
    };

    Runnable postProdutos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRODUTOS)).getServiceSpecs();
        String endpoint = "/skyhub/products";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRODUTOS));
    };

    Runnable postDeleteProdutosSkyhub = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DELETE_PRODUTOS_SKYHUB)).getServiceSpecs();
        String endpoint = "/skyhub/delete-products";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DELETE_PRODUTOS_SKYHUB));
    };

    Runnable postAPIFretes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_API_FRETES)).getServiceSpecs();
        String endpoint = "/skyhub/deliveries";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_API_FRETES));
    };

    Runnable postRappiOrder = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_RAPPI_ORDER)).getServiceSpecs();
        String endpoint = "/rappi/order";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_RAPPI_ORDER));
    };

    Runnable postIfoodToken = () -> {
        // TODO Ajustar esse e os próximos services conforme for definido
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_IFOOD_TOKEN)).getServiceSpecs();
        String endpoint = "/oauth/token";
        specs.setUrl("https://service.sitemercado.com.br/api/v1/oauth/token");
        //specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_IFOOD_TOKEN));
    };
}