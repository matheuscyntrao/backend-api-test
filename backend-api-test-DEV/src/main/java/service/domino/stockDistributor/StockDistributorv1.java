package service.domino.stockDistributor;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface StockDistributorv1 extends ServiceBase {

    String dominio = "/distributor";
    String url = Util.uri.apply("distributor-stock-service") + dominio;

    String GET_DISTRIBUTOR_SUBSIDIARY_ID_STOCK = "StockDistributor-v1-GetDistributorSubsidiaryIdStock";
    String GET_DISTRIBUTOR_ID_STOCK = "StockDistributor-v1-GetDistributorIdStock";
    String POST_DISTRIBUTOR_ORDER_VALIDATE = "StockDistributor-v1-PostDistributorOrderValidate";
    String POST_DISTRIBUTOR_ORDER = "StockDistributor-v1-PostDistributorOrder";

    Runnable getDistributorSubsidiaryIdStock = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_DISTRIBUTOR_SUBSIDIARY_ID_STOCK)).getServiceSpecs();
        String endpoint = "/v1/distributor/subsidiary/{id}/stock";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_DISTRIBUTOR_SUBSIDIARY_ID_STOCK));
    };

    Runnable getDistributorIdStock = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_DISTRIBUTOR_ID_STOCK)).getServiceSpecs();
        String endpoint = "/v1/distributor/{id}/stock";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_DISTRIBUTOR_ID_STOCK));
    };

    Runnable postDistributorOrderValidate = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DISTRIBUTOR_ORDER_VALIDATE)).getServiceSpecs();
        String endpoint = "/v1/distributor/order/validate";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DISTRIBUTOR_ORDER_VALIDATE));
    };

    Runnable postDistributorOrder = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DISTRIBUTOR_ORDER)).getServiceSpecs();
        String endpoint = "/v1/distributor/order";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DISTRIBUTOR_ORDER));
    };
}
