package service.brocacao.omniDashboardBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Coveragev1 extends ServiceBase {

    String dominio = "/omni-dashboard-bff";
    String url = Util.uri.apply("omni-dashboard-bff") + dominio;
    String GET_POSSIVEIS_FILTROS = "Brocacao-Bff-v1-GetItemPossiveisFiltros";
    String GET_POSSIVEIS_FILTROS_FILTER = "Brocacao-Bff-v1-GetItemPossiveisFiltrosSearch";

    Runnable getPossiveisFiltros = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_POSSIVEIS_FILTROS)).getServiceSpecs();
        String endpoint = "/v1/coverage";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_POSSIVEIS_FILTROS));
    };

    Runnable getPossiveisFiltrosSearch = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_POSSIVEIS_FILTROS_FILTER)).getServiceSpecs();
        String endpoint = "/v1/coverage/{coverageType}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_POSSIVEIS_FILTROS_FILTER));
    };

}
