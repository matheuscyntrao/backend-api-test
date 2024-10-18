package stepdef.timeB.skyhub;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.skyhub.response.ProductProducts;
import service.timeB.skyhub.Skyhub;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class GetSkyhubProdutos_Steps {
    @Dado("possuo dados para Skyhub - v1 - GetProdutos")
    public void possuo_dados_para_skyhub_v1_get_produtos() {
        BuilderRequest.simple.accept(Util.rota.apply(Skyhub.GET_PRODUTOS));
    }

    @Quando("executo SkyHub - v1 - GetProdutos")
    public void executo_sky_hub_v1_get_produtos() {
        Skyhub.getProdutos.run();
    }

    @Entao("sistema processa SkyHub - v1 - GetProdutos:")
    public void sistema_processa_sky_hub_v1_get_produtos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Skyhub.GET_PRODUTOS)).getServiceResponse()
                , ProductProducts.class
        );
    }

}
