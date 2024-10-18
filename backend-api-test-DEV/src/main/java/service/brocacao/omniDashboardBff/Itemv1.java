package service.brocacao.omniDashboardBff;

import utils.Util;
import utils.service.ServiceBase;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceSpecs;

public interface Itemv1 extends ServiceBase {

    String dominio = "/omni-dashboard-bff";
    String url = Util.uri.apply("omni-dashboard-bff") + dominio;

    String GET_ITEM = "Brocacao-Bff-v1-GetItens";
    String GET_ITEM_ATRIBUTOS = "Brocacao-Bff-v1-GetItemAtributos";
    String GET_ITEM_POSSIVEIS_FILTROS = "Brocacao-Bff-v1-GetItemPossiveisFiltros";

    Runnable getItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM)).getServiceSpecs();
        String endpoint = "/v1/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM));
    };

    Runnable getItemAtributos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_ATRIBUTOS)).getServiceSpecs();
        String endpoint = "/v1/item/{atributo}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_ATRIBUTOS));
    };

    Runnable getPossiveisFiltros = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_POSSIVEIS_FILTROS)).getServiceSpecs();
        String endpoint = "/v1/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_POSSIVEIS_FILTROS));
    };

}
