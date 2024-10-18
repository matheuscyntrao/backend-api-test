package stepdef.avengers.filialVirtual;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Publico;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Uf;
import org.testng.Assert;
import queries.avengers.filialVirtual.FilialVirtualPublicoQuerie;
import queries.avengers.filialVirtual.FilialVirtualUFQuerie;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.assertEquals;


public class BuscarPublicos_v1Steps {

    @Dado("possuo dados para FilialVirtual - v1 - GetPublicos$")
    public void possuoDadosParaFilialVirtualVGetPublicos() {
        BuilderRequest.simple.accept(Util.rota.apply(FilialVirtualv1.GET_PUBLICOS));
    }

    @Quando("^executo FilialVirtual - v1 - GetPublicos")
    public void executo_FilialVirtual_v1_GetPublicos() throws Throwable {
        FilialVirtualv1.getPublicos.run();
    }

    @Entao("^sistema processa FilialVirtual - v1 - GetPublicos:$")
    public void sistema_processa_FilialVirtual_v1_GetPublicos(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_PUBLICOS)).getServiceResponse()
                , FilialVirtualResponse_v1_Publico[].class
        );
    }

    @E("valido FilialVirtual - v1 - GetPublicos")
    public void validoFilialVirtualVGetPublicos() {
        Integer statusCode = Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_PUBLICOS)).getServiceResponse().getStatusCode();
        List<FilialVirtualResponse_v1_Publico> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_PUBLICOS)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Publico[].class).clone());
        List<FilialVirtualResponse_v1_Publico> esperado = FilialVirtualPublicoQuerie.getPublicos();
        assumingThat(response.size() > 0, () -> {
            esperado.sort(Comparator.comparing(FilialVirtualResponse_v1_Publico::getTipoPublico));
            response.sort(Comparator.comparing(FilialVirtualResponse_v1_Publico::getTipoPublico));
            assertAll(
                    () -> assertEquals(response, esperado)
                    , () -> assertEquals((int) statusCode, 200)
            );
        });
        assumingThat(response.size() == 0, () -> {
            assertEquals((int) statusCode, 204);
        });
    }
}
