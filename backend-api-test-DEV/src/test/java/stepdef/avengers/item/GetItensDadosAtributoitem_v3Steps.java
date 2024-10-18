package stepdef.avengers.item;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.item.enums.AtributoItemEnum;
import model.avengers.item.response.GetItensAtributos_v3Response;
import org.testng.Assert;
import queries.avengers.item.ItensQuerie;
import service.avengers.item.Itemv3;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.assertEquals;

public class GetItensDadosAtributoitem_v3Steps {
    @Dado("possuo dados para Item - v3 - GetItensDadosAtributoitem:")
    public void possuo_dados_para_item_v3_get_itens_dados_atributo_item(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM), dataTable);
    }

    @Quando("executo Item - v3 - GetItensDadosAtributoitem")
    public void executo_item_v3_get_itens_dados_atributo_item() {
        Itemv3.getItensDadosAtributoitem.run();
    }

    @Entao("sistema processa Item - v3 - GetItensDadosAtributoitem")
    public void sistema_processa_item_v3_get_itens_dados_atributo_item(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM)).getServiceResponse()
                , String[].class
        );
    }

    @Entao("valido Item - v3 - GetItensDadosAtributoitem:")
    public void valido_item_v3_get_itens_dados_atributo_item(DataTable dataTable) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM)).getServiceResponse().getStatusCode() == 200, () -> {
            GetItensAtributos_v3Response[] esperado = CucumberUtils.getObjectBody(dataTable, GetItensAtributos_v3Response[].class);
            List<String> esperadoList = new ArrayList<>();
            List<String> responseList = Arrays.asList(Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM)).getServiceResponse().getObjectBody(String[].class).clone());
            for (GetItensAtributos_v3Response getItensAtributos_v3Response : esperado) {
                esperadoList.add(getItensAtributos_v3Response.getNomeAtributo());
            }
            Collections.sort(esperadoList);
            Collections.sort(responseList);
            Assert.assertEquals(responseList, esperadoList);
        });
    }

    @Entao("valido Item - v3 - GetItensDadosAtributoitem {string}")
    public void valido_item_v3_get_itens_dados_atributo_item(String item) {
        List<String> itensRepository = ItensQuerie.getTiposItem(AtributoItemEnum.valueOf(item).getNomeAtributoBase());
        Integer statusCode = Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM)).getServiceResponse().getStatusCode();
        assumingThat(itensRepository.size() > 0, () -> {
            List<String> responseList = Arrays.asList(Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM)).getServiceResponse().getObjectBody(String[].class).clone());
            Collections.sort(itensRepository);
            Collections.sort(responseList);
            Assert.assertEquals(responseList, itensRepository);
            assertAll(
                    () -> assertEquals(responseList, itensRepository)
                    , () -> assertEquals((int) statusCode, 200)
            );
        });
        assumingThat(itensRepository.size() == 0, () -> assertEquals((int) statusCode, 204));
    }

    @Entao("valido Item - v3 - GetItensDadosAtributoitem mensagem de erro {string}")
    public void valido_item_v3_get_itens_dados_atributoitem_mensagem_de_erro(String mensagemPrevista) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM)).getServiceResponse().getStatusCode() != 200, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_DADOS_ITEM)).getServiceResponse().getBody();
            Assert.assertEquals(mensagemRetorno, mensagemPrevista);
        });
    }
}
