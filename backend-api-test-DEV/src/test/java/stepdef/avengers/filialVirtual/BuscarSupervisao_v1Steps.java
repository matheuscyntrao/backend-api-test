package stepdef.avengers.filialVirtual;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Supervisao;
import org.testng.Assert;
import queries.avengers.filialVirtual.FilialVirtualSupervisaoQuerie;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BuscarSupervisao_v1Steps {

    @Dado("possuo dados para FilialVirtual - v1 - GetSupervisao")
    public void possuoDadosParaFilialVirtualVGetSupervisao() {
        BuilderRequest.simple.accept(Util.rota.apply(FilialVirtualv1.GET_SUPERVISAO));
    }

    @Quando("^executo FilialVirtual - v1 - GetSupervisao")
    public void executo_FilialVirtual_v1_GetSupervisao() {
        FilialVirtualv1.getSupervisao.run();
    }

    @Entao("sistema processa FilialVirtual - v1 - GetSupervisao:$")
    public void sistemaProcessaFilialVirtualVGetSupervisao(DataTable dataTable) throws Throwable {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_SUPERVISAO)).getServiceResponse()
                , FilialVirtualResponse_v1_Supervisao[].class);
    }

    @E("valido FilialVirtual - v1 - GetSupervisao")
    public void validoFilialVirtualVGetSupervisao() {
        List<FilialVirtualResponse_v1_Supervisao> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_SUPERVISAO)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Supervisao[].class).clone());
        List<FilialVirtualResponse_v1_Supervisao> esperado = FilialVirtualSupervisaoQuerie.getSupervisao();
        esperado.sort(Comparator.comparing(FilialVirtualResponse_v1_Supervisao::getDescricaoAreaSupervisao));
        response.sort(Comparator.comparing(FilialVirtualResponse_v1_Supervisao::getDescricaoAreaSupervisao));
        Assert.assertEquals(response, esperado);
    }

}
