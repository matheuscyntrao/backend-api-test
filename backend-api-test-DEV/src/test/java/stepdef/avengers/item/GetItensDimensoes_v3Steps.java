package stepdef.avengers.item;

import entity.avangers.item.MedidaItemEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.item.response.GetItensDimensoesResponse_v3;
import queries.avengers.item.ItensQuerie;
import service.avengers.item.Itemv3;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetItensDimensoes_v3Steps {
    private static String ROTA = Itemv3.GET_ITENS_DIMENSOES;

    @Dado("possuo dados para Item - v3 - GetItensDimensoes:")
    public void possuo_dados_para_item_v3_get_itens_dimensoes(Map<String, String> codItem) {
        BuilderRequest.param.accept(Util.rota.apply(ROTA), codItem);
    }

    @Quando("executo Item - v3 - GetItensDimensoes")
    public void executo_item_v3_get_itens_dimensoes() {
        Itemv3.getItensDimensoes.run();
    }

    @Entao("sistema processa Item - v3 - GetItensDimensoes")
    public void sistema_processa_item_v3_get_itens_dimensoes(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetItensDimensoesResponse_v3[].class
        );
    }

    @Entao("valido item - v3 - getDimensoes tabela medida_do_item")
    public void valido_item_v3_get_dimensoes_tabela_medida_do_item() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            List<GetItensDimensoesResponse_v3> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(GetItensDimensoesResponse_v3[].class).clone());
            response.forEach(item -> {
                MedidaItemEntity medidas = ItensQuerie.getMedidaItem(item.getCodigoItem());
                assertAll(
                        () -> assertEquals(item.getAltura(), medidas.getAltura())
                        , () -> assertEquals(item.getComprimento(), medidas.getComprimento())
                        , () -> assertEquals(item.getLargura(), medidas.getLargura())
                        , () -> assertEquals(item.getPeso(), medidas.getPeso())
                        , () -> assertEquals(item.getVolume(), medidas.getVolume())
                );
            });
        });
    }
}
