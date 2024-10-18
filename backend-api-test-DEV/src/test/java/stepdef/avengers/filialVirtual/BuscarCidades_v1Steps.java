package stepdef.avengers.filialVirtual;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Cidade;
import queries.avengers.filialVirtual.FilialVirtualCidadesQuerie;
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

public class BuscarCidades_v1Steps {

    @Dado("^possuo dados para FilialVirtual - v1 - GetCidades$")
    public void possuo_dados_para_FilialVirtual_v1_GetCidades() {
        BuilderRequest.simple.accept(Util.rota.apply(FilialVirtualv1.GET_CIDADES));
    }

    @Quando("^executo FilialVirtual - v1 - GetCidades$")
    public void executo_FilialVirtual_v1_GetCidades() {
        FilialVirtualv1.getCidades.run();
    }

    @Entao("^sistema processa FilialVirtual - v1 - GetCidades:$")
    public void sistema_processa_FilialVirtual_v1_GetCidades(DataTable arg1) throws Exception {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_CIDADES)).getServiceResponse()
                , FilialVirtualResponse_v1_Cidade[].class
        );
    }

    @E("valido FilialVirtual - v1 - GetCidades$")
    public void validoFilialVirtualVGetCidades() {
        Integer statusCode = Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_CIDADES)).getServiceResponse().getStatusCode();
        List<FilialVirtualResponse_v1_Cidade> esperado = FilialVirtualCidadesQuerie.getCidades();
        List<FilialVirtualResponse_v1_Cidade> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_CIDADES)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Cidade[].class).clone());
        assumingThat(response.size() > 0, () -> {
            esperado.sort(Comparator.comparing(FilialVirtualResponse_v1_Cidade::getNome));
            response.sort(Comparator.comparing(FilialVirtualResponse_v1_Cidade::getNome));
            System.out.println(response + "\n" + esperado);
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
