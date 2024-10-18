package stepdef.avengers.item;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.item.response.GetItensAutocompleteResponse_v3;
import service.avengers.item.Itemv3;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetItensAutocomplete_v3Steps {
    @Dado("possuo dados para Item - v3 - GetItensAutocomplete param:")
    public void possuo_dados_para_item_v3_get_itens_autocomplete_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(Itemv3.GET_ITENS_AUTOCOMPLETE), dataTable);
    }

    @Quando("executo Item - v3 - GetItensAutocomplete")
    public void executo_item_v3_get_itens_autocomplete() {
        Itemv3.getItensAutocomplete.run();
    }

    @Entao("sistema processa Item - v3 - GetItensAutocomplete:")
    public void sistema_processa_item_v3_get_itens_autocomplete(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Itemv3.GET_ITENS_AUTOCOMPLETE)).getServiceResponse()
                , GetItensAutocompleteResponse_v3.class
        );
    }
}
