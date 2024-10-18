package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import service.avengers.mostruario.Mostruariov3;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscarItensBarcode_v3Steps {
    @Dado("^possuo dados para Mostruario - v3 - GetBarcode path :$")
    public void possuo_dados_para_Mostruario_v3_GetBarcode_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Mostruariov3.GET_BARCODE), arg1);
    }

    @Dado("^possuo dados para Mostruario - v3 - GetBarcode param :$")
    public void possuo_dados_para_Mostruario_v3_GetBarcode_param(Map<String, String> arg1) throws Throwable {
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.GET_BARCODE)).getServiceSpecs().param.putAll(arg1);
    }

    @Quando("^executo Mostruario - v3 - GetBarcode$")
    public void executo_Mostruario_v3_GetBarcode() throws Throwable {
        Mostruariov3.getBarcode.run();
    }

    @Entao("^sistema processa Mostruario - v3 - GetBarcode:$")
    public void sistema_processa_Mostruario_v3_GetBarcode(DataTable arg1) throws Throwable {
        //TODO:Falta fazer
    }
}
