package stepdef.brocacao.omniDashboardBff;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.brocacao.omniDashboardBff.Coverage.CoverageSpecifc_v1Response;
import model.brocacao.omniDashboardBff.Coverage.CoverageValues;
import org.testng.Assert;
import queries.brocacao.omniDashboardBff.*;
import service.brocacao.omniDashboardBff.Coveragev1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class CoverageFilters_v1Steps {

    @Dado("possuo dados para Bff Coverage - v1 - GetPossiveisFiltrosSearch:")
    public void possuoDadosParaBffCoverageV1GetPossiveisFiltros(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER), dataTable);
    }

    @Quando("executo Bff Coverage - v1 - GetPossiveisFiltrosSearch")
    public void executoBffCoverageV1GetPossiveisFiltrosSearch() {
        Coveragev1.getPossiveisFiltrosSearch.run();
    }

    @Entao("sistema processa Bff Coverage - v1 - GetPossiveisFiltrosSearch:")
    public void sistemaProcessaBffCoverageV1GetPossiveisFiltrosSearch(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER)).getServiceResponse()
                , CoverageSpecifc_v1Response.class
        );
    }

    @E("valido Bff Coverage - v1 - GetPossiveisFiltrosSearch {string}")
    public void validoBffCoverageV1GetPossiveisFiltrosSearch(String mensagemPrevista) {

        assumingThat(Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER)).getServiceResponse().getStatusCode() == 200, () -> {


            CoverageSpecifc_v1Response response = Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER)).getServiceResponse().getObjectBody(CoverageSpecifc_v1Response.class);
            CoverageSpecifc_v1Response esperado = new CoverageSpecifc_v1Response();
            esperado.setCoverageType(response.getCoverageType());

            esperado.setCoverageColumnTypeDetail(response.getCoverageColumnTypeDetail());

            switch (response.getCoverageType()) {
                case "UF":
                    esperado.setCoverageValues(UFQuerie.getUfs());
                    break;
                case "FILIAL":
                    esperado.setCoverageValues(FilialQuerie.getFiliais());
                    break;
                case "AREA_SUPERVISAO":
                    esperado.setCoverageValues(SupervisaoQuerie.getSupervisao());
                    break;
                case "CIDADE":
                    esperado.setCoverageValues(CidadesQuerie.getCidades());
                    break;
                case "BAIRRO":
                    List<CoverageValues> coverageValues = BairrosQuerie.getBairros();
                    List<String> bairros = new ArrayList<>();
                    coverageValues.forEach( el -> bairros.add(el.getNomeBairro()));
                    esperado.setCoverageValues(bairros);
                    break;
                case "CANAL":
                    esperado.setCoverageValues(List.of("ALO", "APP", "LOJA", "SITE"));
                    break;
                case "PUBLICO":
                    esperado.setCoverageValues(PublicoQuerie.getPublicos());
                    break;
                default:
                    esperado.setCoverageValues(Collections.emptyList());
                    break;
            }

            esperado.setCoverageValues(esperado.getCoverageValues().stream().sorted().collect(Collectors.toList()));
            response.setCoverageValues(response.getCoverageValues().stream().sorted().collect(Collectors.toList()));
            Assert.assertEquals(response, esperado);
        });
        assumingThat(Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER)).getServiceResponse().getStatusCode() == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
        assumingThat(Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER)).getServiceResponse().getStatusCode() == 500, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(Coveragev1.GET_POSSIVEIS_FILTROS_FILTER)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
    };
}
