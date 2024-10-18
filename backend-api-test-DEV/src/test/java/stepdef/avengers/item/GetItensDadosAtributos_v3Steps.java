package stepdef.avengers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.item.response.GetItensAtributos_v3Response;
import org.testng.Assert;
import service.avengers.item.Itemv3;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.lang.reflect.Array;
import java.util.*;

public class GetItensDadosAtributos_v3Steps {
    @Dado("possuo dados para Item - v3 - GetItensDadosAtributos")
    public void possuo_dados_para_item_v3_get_itens_dados_atributos() {
        BuilderRequest.simple.accept(Util.rota.apply(Itemv3.GET_ITENS_ATRIBUTOS));
    }

    @Quando("executo Item - v3 - GetItensDadosAtributos")
    public void executo_item_v3_get_itens_dados_atributo() {
        Itemv3.getItensDadosAtributos.run();
    }

    @Entao("sistema processa Item - v3 - GetItensDadosAtributos")
    public void sistema_processa_item_v3_get_itens_dados_atributos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_ATRIBUTOS)).getServiceResponse()
                , GetItensAtributos_v3Response[].class
        );
    }

    @Entao("valido Item - v3 - GetItensDadosAtributos:")
    public void valido_item_v3_get_itens_dados_atributo(DataTable dataTable) throws JsonProcessingException {
        List<GetItensAtributos_v3Response> esperado = Arrays.asList(CucumberUtils.getObjectBody(dataTable, GetItensAtributos_v3Response[].class).clone());
        List<GetItensAtributos_v3Response> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_ATRIBUTOS)).getServiceResponse().getObjectBody(GetItensAtributos_v3Response[].class).clone());
        esperado.sort(Comparator.comparing(GetItensAtributos_v3Response::getValorAtributo));
        response.sort(Comparator.comparing(GetItensAtributos_v3Response::getValorAtributo));
        response.stream().iterator().forEachRemaining(a-> a.setNomeAtributo(null));
        Assert.assertEquals( response, esperado);
    }
}
