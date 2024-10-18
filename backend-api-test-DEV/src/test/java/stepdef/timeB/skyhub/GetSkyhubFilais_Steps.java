package stepdef.timeB.skyhub;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.skyhub.response.Subsidiary_Stores;
import service.timeB.skyhub.Skyhub;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetSkyhubFilais_Steps {

    @Dado("possuo dados para Skyhub - v1 - GetFiliais")
    public void possuo_dados_para_skyhub_v1_get_filiais() {
        BuilderRequest.simple.accept(Util.rota.apply(Skyhub.GET_FILIAIS));
    }

    @Quando("executo SkyHub - v1 - GetFiliais")
    public void executo_sky_hub_v1_get_filiais() {
        Skyhub.getFiliais.run();
    }

    @Entao("sistema processa SkyHub - v1 - GetFiliais:")
    public void sistema_processa_sky_hub_v1_get_filiais(io.cucumber.datatable.DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                        , Cache.chamadas.get(Util.rota.apply(Skyhub.GET_FILIAIS)).getServiceResponse()
                        , Subsidiary_Stores.class
                );
        System.out.println(Skyhub.GET_FILIAIS);
    }

    @Before("@skyhub-token")
    public static void geraToken() {
        assumingThat(Cache.tokenSkyHub == null, () -> {
            Cache.tokenSkyHub = Skyhub.generateSkyhubToken.get();
        });
        System.out.println(Cache.tokenSkyHub);
    }

}
