package stepdef.digital.category;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.category.response.GetCategoryResponse_v1;
import service.digital.category.Category_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetCategory_v1Steps {
    private static String ROTA = Category_v1.GET_CATEGORY;

    @Dado("que possuo dados para Category - v1 - GetCategory path:")
    public void que_possuo_dados_para_category_v1_get_category_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);

    }

    @Dado("que possuo dados para Category - v1 - GetCategory param:")
    public void que_possuo_dados_para_category_v1_get_category_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo Category - v1 - GetCategory")
    public void executo_category_v1_get_category() {
        Category_v1.getCategory.run();
    }

    @Entao("sistema processa Campaign - v1 - GetCategory:")
    public void sistema_processa_campaign_v1_get_category(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
            , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
            , GetCategoryResponse_v1.class);
    }
}
