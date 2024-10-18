package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.response.PrecosResponse_v3;
import service.avengers.mostruario.Mostruariov3;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscaPrecos_v3Steps {
    @Dado("^possuo dados para Mostruario - v3 - GetPrecos param :$")
    public void possuo_dados_para_Mostruario_v3_GetPrecos_param(Map<String, String> arg1) throws Throwable {
        BuilderRequest.param.accept(Util.rota.apply(Mostruariov3.GET_PRECOS), arg1);
    }

    @Quando("^executo Mostruario - v3 - GetPrecos$")
    public void executo_Mostruario_v3_GetPrecos() throws Throwable {
        Mostruariov3.getPrecos.run();
    }

    @Entao("^sistema processa Mostruario - v3 - GetPrecos:$")
    public void sistema_processa_Mostruario_v3_GetPrecos(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_PRECOS)).getServiceResponse()
                , PrecosResponse_v3[].class
        );
    }
}
