
package stepdef.timeB.skyhub;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.gson.Gson;
import model.timeB.skyhub.request.Product_Product;
import model.timeB.skyhub.response.Product;
import service.timeB.skyhub.Skyhub;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class PutSkyhubProdutos_Steps {

    @Dado("possuo dados para Skuhub - v1 - PutProdutos:")
    public void possuo_dados_para_skuhub_v1_put_produtos(Map<String, String> dataTable) throws JsonProcessingException {
        Gson gson = new Gson();
        Map jsonNodes = gson.fromJson(Cache.chamadas.get(Util.rota.apply(Skyhub.GET_PRODUTOS_CODE)).getServiceResponse().getBody(), Map.class);
        jsonNodes.replace(dataTable.get("field"), dataTable.get("value"));
        Product product = CucumberUtils.getObjectBodyFromJson(gson.toJson(jsonNodes), Product.class);
        Product_Product product_product = Product_Product.builder().product(product).build();
        BuilderRequest.body.accept(Util.rota.apply(Skyhub.PUT_PRODUTO), product_product);
    }

    @E("possuo dados para Skyhub - v1 - PutProdutos path:")
    public void possuo_dados_para_skyhub_v1_put_produtos_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Skyhub.PUT_PRODUTO), dataTable);
    }

    @Quando("executo Skyhub - v1 - PutProdutos")
    public void executo_skyhub_v1_put_produtos() {
        Skyhub.putProdutos.run();
    }

    @Entao("sistema processa Skyhub - v1 - PutProdutos:")
    public void sistema_processa_skyhub_v1_put_produtos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Skyhub.PUT_PRODUTO)).getServiceResponse()
                , String.class
        );
    }
}
