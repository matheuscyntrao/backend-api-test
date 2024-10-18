package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.response.ItensSimilaresResponse_v3;
import service.avengers.mostruario.Mostruariov3;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscarItensSimilares_v3Steps {
    @Dado("^possuo dados para Mostruario - v3 - GetSimilares path :$")
    public void possuo_dados_para_Mostruario_v3_GetSimilares_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Mostruariov3.GET_ITEM_SIMILARES), arg1);
    }

    @Dado("^possuo dados para Mostruario - v3 - GetSimilares param :$")
    public void possuo_dados_para_Mostruario_v3_GetSimilares_param(Map<String, String> arg1) throws Throwable {
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_ITEM_SIMILARES)).getServiceSpecs().param.putAll(arg1);
    }

    @Quando("^executo Mostruario - v3 - GetSimilares$")
    public void executo_Mostruario_v3_GetSimilares() throws Throwable {
        Mostruariov3.getItemSimilares.run();
    }

    @Entao("^sistema processa Mostruario - v3 - GetSimilares:$")
    public void sistema_processa_Mostruario_v3_GetSimilares(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_ITEM_SIMILARES)).getServiceResponse()
                , ItensSimilaresResponse_v3.class
        );

    }
}
