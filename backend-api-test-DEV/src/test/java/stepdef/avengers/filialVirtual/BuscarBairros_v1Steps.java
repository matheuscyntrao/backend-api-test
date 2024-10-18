package stepdef.avengers.filialVirtual;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Bairro;
import model.digital.shoppingCart.enums.ShippingMethodEnum;
import org.testng.Assert;
import org.testng.SkipException;
import queries.avengers.filialVirtual.FilialVirtualBairrosQuerie;
import queries.timeB.marketplaceSeller.TableQuerie;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BuscarBairros_v1Steps {

    @Dado("possuo dados para FilialVirtual - v1 - GetBairros$")
    public void possuoDadosParaFilialVirtualVGetBairros() {
        BuilderRequest.simple.accept(Util.rota.apply(FilialVirtualv1.GET_BAIRROS));
    }

    @Quando("^executo FilialVirtual - v1 - GetBairros$")
    public void executo_FilialVirtual_v1_GetBairros() {
        FilialVirtualv1.getBairros.run();
    }

    @Entao("sistema processa FilialVirtual - v1 - GetBairros:$")
    public void sistemaProcessaFilialVirtualVGetBairros(DataTable dataTable) throws Throwable {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_BAIRROS)).getServiceResponse()
                , FilialVirtualResponse_v1_Bairro[].class);
        System.out.println(FilialVirtualv1.GET_BAIRROS);
    }

    @E("valido FilialVirtual - v1 - GetBairros$")
    public void validoFilialVirtualVGetBairros() {
        List<FilialVirtualResponse_v1_Bairro> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_BAIRROS)).getServiceResponse().getObjectBody(FilialVirtualResponse_v1_Bairro[].class).clone());
        List<FilialVirtualResponse_v1_Bairro> esperado = FilialVirtualBairrosQuerie.getBairros();
        esperado.sort(Comparator.comparing(FilialVirtualResponse_v1_Bairro::getDescricao));
        response.sort(Comparator.comparing(FilialVirtualResponse_v1_Bairro::getDescricao));
        Assert.assertEquals(response, esperado);
    }
}
