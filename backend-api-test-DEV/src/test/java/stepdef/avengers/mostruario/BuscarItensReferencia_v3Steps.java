package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.response.ItensReferencia_v3;
import service.avengers.mostruario.Mostruariov3;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscarItensReferencia_v3Steps {
    @Dado("^possuo dados para Mostruario - v3 - GetReferencia path :$")
    public void possuo_dados_para_Mostruario_v3_GetReferencia_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Mostruariov3.GET_ITEM_REFERENCIA), arg1);
    }

    @Dado("^possuo dados para Mostruario - v3 - GetReferencia param :$")
    public void possuo_dados_para_Mostruario_v3_GetReferencia_param(Map<String, String> arg1) throws Throwable {
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_ITEM_REFERENCIA)).getServiceSpecs().param.putAll(arg1);
    }

    @Quando("^executo Mostruario - v3 - GetReferencia$")
    public void executo_Mostruario_v3_GetReferencia() throws Throwable {
        Mostruariov3.getItemReferencia.run();
    }

    @Entao("^sistema processa Mostruario - v3 - GetReferencia:$")
    public void sistema_processa_Mostruario_v3_GetReferencia(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_ITEM_REFERENCIA)).getServiceResponse()
                , ItensReferencia_v3.class
        );
    }
}
