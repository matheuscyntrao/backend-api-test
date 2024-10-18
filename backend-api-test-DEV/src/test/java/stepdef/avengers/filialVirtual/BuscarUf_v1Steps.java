package stepdef.avengers.filialVirtual;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Uf;
import org.testng.Assert;
import queries.avengers.filialVirtual.FilialVirtualUFQuerie;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.*;

public class BuscarUf_v1Steps {

    private FilialVirtualResponse_v1_Uf findUf(String searchUf, List<FilialVirtualResponse_v1_Uf> object) {
        return object.stream().filter(uf -> uf.getUf().equals(searchUf)).findFirst().orElse(null);
    }

    @Dado("possuo dados para FilialVirtual - v1 - GetUf")
    public void possuoDadosParaFilialVirtualVGetUf() {
        BuilderRequest.simple.accept(Util.rota.apply(FilialVirtualv1.GET_UF));
    }

    @Quando("^executo FilialVirtual - v1 - GetUf")
    public void executo_FilialVirtual_v1_GetUf() throws Throwable {
        FilialVirtualv1.getUf.run();
    }

    @Entao("^sistema processa FilialVirtual - v1 - GetUf:$")
    public void sistema_processa_FilialVirtual_v1_GetUf(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_UF)).getServiceResponse()
                , FilialVirtualResponse_v1_Uf[].class
        );
    }

    @Entao("valido FilialVirtual - v1 - GetUf criterios aceite:")
    public void validoFilialVirtualVGetUfCriteriosAceite(Map<String, String> dataTable) throws JsonProcessingException {
        List<FilialVirtualResponse_v1_Uf> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_UF)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Uf[].class).clone());
        String uf_cucumber = dataTable.get("uf");
        List<FilialVirtualResponse_v1_Uf> esperado = FilialVirtualUFQuerie.getUfs();
        Assert.assertEquals(findUf(uf_cucumber, response), findUf(uf_cucumber, esperado));
    }

    @Entao("valido FilialVirtual - v1 - GetUf")
    public void valido_filial_virtual_v1_get_uf() {
        List<FilialVirtualResponse_v1_Uf> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_UF)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Uf[].class).clone());
        List<FilialVirtualResponse_v1_Uf> esperado = FilialVirtualUFQuerie.getUfs();
        esperado.sort(Comparator.comparing(FilialVirtualResponse_v1_Uf::getUf));
        response.sort(Comparator.comparing(FilialVirtualResponse_v1_Uf::getUf));
        Assert.assertEquals(response, esperado);
    }

}
