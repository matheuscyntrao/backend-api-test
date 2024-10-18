package stepdef.avengers.filialVirtual;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Filial;
import org.testng.Assert;
import queries.avengers.filialVirtual.FilialVirtualFilialQuerie;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BuscarFiliais_v1Steps {

    @Dado("possuo dados para FilialVirtual - v1 - GetFiliais$")
    public void possuoDadosParaFilialVirtualVGetFiliais() {
        BuilderRequest.simple.accept(Util.rota.apply(FilialVirtualv1.GET_FILIAIS));
    }

    @Quando("^executo FilialVirtual - v1 - GetFiliais$")
    public void executo_FilialVirtual_v1_GetFiliais() {
        FilialVirtualv1.getFiliais.run();
    }

    @Entao("sistema processa FilialVirtual - v1 - GetFiliais:$")
    public void sistemaProcessaFilialVirtualVGetFiliais(DataTable dataTable) throws Throwable {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_FILIAIS)).getServiceResponse()
                , FilialVirtualResponse_v1_Filial[].class);
    }

    @E("valido FilialVirtual - v1 - GetFiliais$")
    public void validoFilialVirtualVGetFiliais() {
        List<FilialVirtualResponse_v1_Filial> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_FILIAIS)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Filial[].class).clone());
        List<FilialVirtualResponse_v1_Filial> esperado = FilialVirtualFilialQuerie.getFiliais();
        esperado.sort(Comparator.comparing(FilialVirtualResponse_v1_Filial::getCodigoFilial));
        response.sort(Comparator.comparing(FilialVirtualResponse_v1_Filial::getCodigoFilial));
        Assert.assertEquals(response, esperado);
    };

}
