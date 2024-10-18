package stepdef.brocacao.omniDashboardBff;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.item.enums.AtributoItemEnum;
import model.avengers.item.response.GetItensAtributos_v3Response;
import org.testng.Assert;
import queries.avengers.item.ItensQuerie;
import service.brocacao.omniDashboardBff.Itemv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.assertEquals;

public class ItemAtributos_v1Steps {

    @Dado("possuo dados para Bff Item - v1 - GetItensAtributos:")
    public void possuoDadosParaBffItemVGetItensAtributos(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS), dataTable);
    }

    @Quando("executo Bff Item - v1 - GetItensAtributos")
    public void executoBffItemVGetItensAtributos() {
        Itemv1.getItemAtributos.run();
    }

    @Entao("sistema processa Bff Item - v1 - GetItensAtributos:")
    public void sistemaProcessaBffItemVGetItensAtributos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS)).getServiceResponse()
                , String[].class
        );
    }

    @E("valido Bff Item - v1 - GetItensAtributos:")
    public void validoBffItemVGetItensAtributos(DataTable dataTable) throws JsonProcessingException {
        assumingThat(Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS)).getServiceResponse().getStatusCode() == 200, () -> {
            GetItensAtributos_v3Response esperado[] = CucumberUtils.getObjectBody(dataTable, GetItensAtributos_v3Response[].class);
            List<String> esperadoList = new ArrayList<>();
            List<String> responseList = Arrays.asList(Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS)).getServiceResponse().getObjectBody(String[].class).clone());
            for (GetItensAtributos_v3Response getItensAtributos_v3Response : esperado) {
                esperadoList.add(getItensAtributos_v3Response.getNomeAtributo());
            }
            Collections.sort(esperadoList);
            Collections.sort(responseList);
            Assert.assertEquals(responseList, esperadoList);
        });
    }

    @E("valido Bff Item - v1 - GetItensAtributos mensagem de erro {string}")
    public void validoBffItemVGetItensAtributosMensagemDeErro(String mensagemPrevista) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS)).getServiceResponse().getStatusCode() != 200, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista));
        });
    }

    @E("valido Bff Item - v1 - GetItensAtributos {string}")
    public void validoBffItemVGetItensAtributos(String item) {
        List<String> itensRepository = ItensQuerie.getTiposItem(AtributoItemEnum.valueOf(item).getNomeAtributoBase());
        Integer statusCode = Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS)).getServiceResponse().getStatusCode();
        assumingThat(itensRepository.size() > 0, () -> {
            List<String> responseList = Arrays.asList(Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM_ATRIBUTOS)).getServiceResponse().getObjectBody(String[].class).clone());
            Collections.sort(itensRepository);
            Collections.sort(responseList);
            Assert.assertEquals(responseList, itensRepository);
            assertAll(
                    () -> assertEquals(responseList, itensRepository)
                    , () -> assertEquals((int) statusCode, 200)
            );
        });
        assumingThat(itensRepository.size() == 0, () -> {
            assertEquals((int) statusCode, 404);
        });
    }
}
