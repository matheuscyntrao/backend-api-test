package stepdef.digital.entrega;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.entrega.orm.Item;
import model.digital.entrega.v3.request.PostEntregas;
import model.digital.entrega.v3.response.PostEntregasResponse;
import model.digital.shippingService.response.PostDeliveriesResponse_v1;
import model.digital.shippingService.response.PostDeliveriesResponse_v1_Deliveries;
import service.digital.entrega.Entrega_v3;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.*;

public class PostEntregaEntregasV3Steps {
    @Dado("que possuo dados para Entrega - v3 - Entregas:")
    public void que_possuo_dados_para_entrega_v3_entregas(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Entrega_v3.POST_ENTREGAS), CucumberUtils.getObjectBody(dataTable, PostEntregas.class));
    }

    @Dado("que possuo dados para Entrega - v3 - Entregas itens:")
    public void que_possuo_dados_para_entrega_v3_entregas_itens(DataTable dataTable) throws JsonProcessingException {
        PostEntregas input = Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_ENTREGAS)).getServiceSpecs().getObjectBody(PostEntregas.class);
        input.setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_ENTREGAS)).getServiceSpecs().setBody(input);
    }

    @Quando("executo Entrega - v3 - Entregas")
    public void executo_entrega_v3_entregas() {
        Entrega_v3.postEntregas.run();
    }

    @Entao("sistema processa Entrega - v3 - Entregas:")
    public void sistema_processa_entrega_v3_entregas(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_ENTREGAS)).getServiceResponse()
                , PostEntregasResponse[].class
        );
    }
    @Entao("valido Entrega - v3 - Entregas {string}")
    public void valido_post_entrega_v3_entregas(String string) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_ENTREGAS)).getServiceResponse().getStatusCode() == 200, () -> {
            validaTypeEntrega(string);
        });
    }

    private void validaTypeEntrega(String tiposEsperado) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_ENTREGAS)).getServiceResponse().getStatusCode() == 200, () -> {
            List<PostEntregasResponse> deliveries = Arrays.asList(Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_ENTREGAS)).getServiceResponse().getObjectBody(PostEntregasResponse[].class).clone());
            List<String> tipoDeEntrega = Arrays.asList(tiposEsperado.split(",").clone());
            tipoDeEntrega.stream().forEach(tipoRetornado -> {

                Optional<PostEntregasResponse> teste = deliveries.stream().filter(
                        filtro -> filtro.getTipoDeEntrega().equals(tipoRetornado)
                ).findFirst();
                assertAll(
                        () -> assertFalse(teste.isEmpty(), "Nenhum tipo de entrega encontrado")
                        , () -> assertEquals(teste.get().getTipoDeEntrega(), tipoRetornado, "tipo de entrega incorreto")
                );
            });
            assertAll(
                    () -> assertTrue(Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_ENTREGAS)).getServiceResponse().getObjectBody(PostEntregasResponse[].class).length> 1)
            );
        });
    }
}
