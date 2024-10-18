package stepdef.avengers.item;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.item.response.GetItensAutocompleteResponse_v2;
import queries.avengers.item.ItensQuerie;
import service.avengers.item.Itemv2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.List;
import java.util.Map;

public class GetItensAutocomplete_v2Steps {
    @Dado("possuo dados para Item - v2 - GetItensAutocomplete param:")
    public void possuo_dados_para_item_v2_get_itens_autocomplete_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(Itemv2.GET_ITENS_AUTOCOMPLETE), dataTable);
    }

    @Quando("executo Item - v2 - GetItensAutocomplete")
    public void executo_item_v2_get_itens_autocomplete() {
        Itemv2.getItensAutocomplete.run();
    }

    @Entao("sistema processa Item - v2 - GetItensAutocomplete:")
    public void sistema_processa_item_v2_get_itens_autocomplete(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Itemv2.GET_ITENS_AUTOCOMPLETE)).getServiceResponse()
                , GetItensAutocompleteResponse_v2[].class
        );
    }

    @Dado("zmuda")
    public void zmuda() {
        List<String> teste = ItensQuerie.getTiposItem("cor");
        System.out.println(teste);
    }
}
