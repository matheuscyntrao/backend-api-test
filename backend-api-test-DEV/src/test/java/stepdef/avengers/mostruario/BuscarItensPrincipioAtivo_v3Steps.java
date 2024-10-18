package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.response.ItensPrincipioAtivoResponse_v3;
import service.avengers.mostruario.Mostruariov3;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscarItensPrincipioAtivo_v3Steps {
    @Dado("^possuo dados para Mostruario - v3 - GetPrincipioAtivo path :$")
    public void possuo_dados_para_Mostruario_v3_GetPrincipioAtivo_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Mostruariov3.GET_ITEM_PRINCIPIOATIVO), arg1);
    }

    @Dado("^possuo dados para Mostruario - v3 - GetPrincipioAtivo param :$")
    public void possuo_dados_para_Mostruario_v3_GetPrincipioAtivo_param(Map<String, String> arg1) throws Throwable {
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_ITEM_PRINCIPIOATIVO)).getServiceSpecs().param.putAll(arg1);
    }

    @Quando("^executo Mostruario - v3 - GetPrincipioAtivo$")
    public void executo_Mostruario_v3_GetPrincipioAtivo() throws Throwable {
        Mostruariov3.getItemPrincipioAtivo.run();
    }

    @Quando("^sistema processa Mostruario - v3 - GetPrincipioAtivo:$")
    public void sistema_processa_Mostruario_v3_GetPrincipioAtivo(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_ITEM_PRINCIPIOATIVO)).getServiceResponse()
                , ItensPrincipioAtivoResponse_v3.class
        );

    }
}
