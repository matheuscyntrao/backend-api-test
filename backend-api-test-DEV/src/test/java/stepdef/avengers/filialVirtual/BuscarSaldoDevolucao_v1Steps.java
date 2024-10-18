package stepdef.avengers.filialVirtual;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscarSaldoDevolucao_v1Steps {
    @Dado("^possuo dados para FilialVirtual - v1 - GetSaldoDevolucao:$")
    public void possuo_dados_para_FilialVirtual_v1_GetSaldoDevolucao_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(FilialVirtualv1.GET_SALDO_DEVOLUCAO), arg1);
    }

    @Dado("^possuo dados para FilialVirtual - v1 - GetSaldoDevolucao param:$")
    public void possuo_dados_para_FilialVirtual_v1_GetSaldoDevolucao_param(Map<String, String> arg1) throws Throwable {
        Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_SALDO_DEVOLUCAO)).getServiceSpecs().param.putAll(arg1);
    }

    @Quando("^executo FilialVirtual - v1 - GetSaldoDevolucao$")
    public void executo_FilialVirtual_v1_GetSaldoDevolucao() throws Throwable {
        FilialVirtualv1.getSaldoDevolucao.run();
    }

    @Entao("^sistema processa FilialVirtual - v1 - GetSaldoDevolucao:$")
    public void sistema_processa_FilialVirtual_v1_GetSaldoDevolucao(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_SALDO_DEVOLUCAO)).getServiceResponse()
                , String.class
        );
    }
}
