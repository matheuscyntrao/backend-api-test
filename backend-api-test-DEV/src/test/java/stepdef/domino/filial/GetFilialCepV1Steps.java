package stepdef.domino.filial;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.filial.response.GetFilialCepResponseV1;
import org.testng.Assert;
import service.avengers.pedido.Pedidov2;
import service.domino.filial.Filialv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetFilialCepV1Steps {
    private static String ROTA = Filialv1.GET_FILIAL_CEP;

    @Dado("possuo dados para Filial - v1 - GetFilialCep path:")
    public void possuo_dados_para_filial_v1_get_filial_cep_path(Map<String, String> cep) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), cep);
    }

    @Quando("executo Filial - v1 - GetFilialCep")
    public void executo_filial_v1_get_filial_cep() {
        Filialv1.getFilialCep.run();
    }


    @Entao("sistema processa Filial - v1 - GetFilialCep:")
    public void sistema_processa_filial_v1_get_filial_cep(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetFilialCepResponseV1.class
        );
    }

    @Entao("valido Filial - v1 - GetFilialCep {string}")
    public void valido_filial_v1_get_filial_cep(String message) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() != 200, () -> {
            Assert.assertEquals(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().body, message, "Mensagem divergente");
        });
    }
}
