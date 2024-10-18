package stepdef.avengers.filialVirtual;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Canal;
import queries.avengers.filialVirtual.FilialVirtualCanaisQuerie;
import service.avengers.filialVirtual.FilialVirtualv1;
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

public class BuscarCanais_v1Steps {

    @Dado("possuo dados para FilialVirtual - v1 - GetCanais$")
    public void possuoDadosParaFilialVirtualVGetCanais() {
        BuilderRequest.simple.accept(Util.rota.apply(FilialVirtualv1.GET_CANAIS));
    }

    @Quando("^executo FilialVirtual - v1 - GetCanais$")
    public void executo_FilialVirtual_v1_GetCanais() {
        FilialVirtualv1.getCanais.run();
    }

    @Entao("sistema processa FilialVirtual - v1 - GetCanais:$")
    public void sistemaProcessaFilialVirtualVGetCanais(DataTable dataTable) throws Throwable {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_CANAIS)).getServiceResponse()
                , FilialVirtualResponse_v1_Canal[].class);
    }

    @E("valido FilialVirtual - v1 - GetCanais$")
    public void validoFilialVirtualVGetCanais() {
        Integer statusCode = Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_CANAIS)).getServiceResponse().getStatusCode();
        List<FilialVirtualResponse_v1_Canal> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_CANAIS)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Canal[].class).clone());
        List<FilialVirtualResponse_v1_Canal> esperado = FilialVirtualCanaisQuerie.getCanais();
        assumingThat(response.size() > 0, () -> {
            esperado.sort(Comparator.comparing(FilialVirtualResponse_v1_Canal::getPerfil));
            response.sort(Comparator.comparing(FilialVirtualResponse_v1_Canal::getPerfil));
            assertAll(
                    () -> assertEquals(response, esperado)
                    , () -> assertEquals((int) statusCode, 200)
            );
        });
        assumingThat(response.size() == 0, () -> {
            assertEquals((int) statusCode, 204);
        });
    };

}
