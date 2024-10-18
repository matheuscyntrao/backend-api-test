package stepdef.domino.filial;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.filial.response.GetFiliaisEstoqueCodItemResponseV1;
import net.minidev.json.parser.JSONParser;
import org.json.JSONObject;
import org.testng.Assert;
import service.domino.filial.Filialv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetFiliaisEstoqueCodItemV1Steps {
    private static String ROTA = Filialv1.GET_FILIAIS_ESTOQUE_CODITEM;

    @Dado("possuo dados para Filial - v1 - GetFiliaisEstoqueCodItem path:")
    public void possuo_dados_para_filial_v1_get_filiais_estoque_cod_item_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);
        BuilderRequest.param.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo Filial - v1 - GetFiliaisEstoqueCodItem")
    public void executo_filial_v1_get_filiais_estoque_cod_item() {
        Filialv1.getFiliaisEstoqueCodItem.run();
    }

    @Entao("sistema processa Filial - v1 - GetFiliaisEstoqueCodItem:")
    public void sistema_processa_filial_v1_get_filiais_estoque_cod_item(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetFiliaisEstoqueCodItemResponseV1[].class
        );
    }

    @Entao("valido Filial - v1 - GetFiliaisEstoqueCodItem {string}")
    public void valido_filial_v1_get_filial_cep(String message) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() != 200 && !Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode().equals(404), () -> {
            Assert.assertEquals(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().body, message, "Mensagem divergente!");
        });
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode().equals(404), () ->{
            JSONObject erro = new JSONObject(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().body);
            Assert.assertEquals(erro.get("message"), message, "Mensagem Divergente!");
        });
    }
}
