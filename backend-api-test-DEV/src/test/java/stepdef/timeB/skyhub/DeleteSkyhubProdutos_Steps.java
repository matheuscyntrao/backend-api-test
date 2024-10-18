package stepdef.timeB.skyhub;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import service.timeB.skyhub.Skyhub;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class DeleteSkyhubProdutos_Steps {

    @Dado("possuo dados para Skyhub - v1 - DeleteProdutos path:")
    public void possuo_dados_para_skyhub_v1_delete_produtos_path(Map<String, String> dataTable) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(Skyhub.DELETE_PRODUTO), dataTable);
    }

    @Quando("executo Skyhub - v1 - DeleteProdutos")
    public void executo_skyhub_v1_delete_produtos() {
        Skyhub.deleteProdutos.run();
    }

    @Entao("sistema processa Skyhub - v1 - DeleteProdutos:")
    public void sistema_processa_skyhub_v1_delete_produtos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Skyhub.DELETE_PRODUTO)).getServiceResponse()
                , String.class
        );
    }
}
