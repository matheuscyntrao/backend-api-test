package stepdef.brocacao.omniDashboardBff;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.brocacao.omniDashboardBff.Coverage.Coverage_v1Response;
import service.brocacao.omniDashboardBff.Coveragev1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class Coverage_v1Steps {

    @Dado("possuo dados para OmniDashbarodBff - v1 - GetPossiveisFiltrosAbrangenciaEOperadoresLogicos")
    public void possuoDadosParaOmniDashbarodBffVGetPossiveisFiltrosAbrangenciaEOperadoresLogicos() {
        BuilderRequest.simple.accept(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS));
    }

    @Quando("executo OmniDashbarodBff - v1 - GetPossiveisFiltrosAbrangenciaEOperadoresLogicos")
    public void executoOmniDashbarodBffVGetPossiveisFiltrosAbrangenciaEOperadoresLogicos() {
        Coveragev1.getPossiveisFiltros.run();
    }

    @Entao("sistema processa OmniDashbarodBff - v1 - GetPossiveisFiltrosAbrangenciaEOperadoresLogicos:")
    public void sistemaProcessaOmniDashbarodBffVGetPossiveisFiltrosAbrangenciaEOperadoresLogicos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS)).getServiceResponse()
                , Coverage_v1Response[].class
        );
    }

}
