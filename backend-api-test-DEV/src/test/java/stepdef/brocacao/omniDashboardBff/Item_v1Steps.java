package stepdef.brocacao.omniDashboardBff;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.brocacao.omniDashboardBff.Items.ItemAttributes;
import model.brocacao.omniDashboardBff.Items.Item_v1Response;
import org.testng.Assert;
import service.brocacao.omniDashboardBff.Itemv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class Item_v1Steps {

    @Dado("possuo dados para OmniDashboard - v1 - GetItens")
    public void possuoDadosParaOmniDashboardV1GetItens() {
        BuilderRequest.simple.accept(Util.rota.apply(Itemv1.GET_ITEM));
    }

    @Quando("executo OmniDashboard - v1 - GetItens")
    public void executoOmniDashboardV1GetItens() {
        Itemv1.getItem.run();
    }

    @Entao("sistema processa OmniDashboard - v1 - GetItens")
    public void sistemaProcessaOmniDashboardV1GetItens(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM)).getServiceResponse()
                , Item_v1Response.class
        );
    }

    @E("valido OmniDashboard - v1 - GetItens:")
    public void validoOmniDashboardV1GetItens(DataTable dataTable) throws JsonProcessingException {
        ItemAttributes[] esperado = CucumberUtils.getObjectBody(dataTable, ItemAttributes[].class);
        Item_v1Response response = Cache.chamadas.get(Util.rota.apply(Itemv1.GET_ITEM)).getServiceResponse().getObjectBody(Item_v1Response.class);
        Assert.assertEquals(response.getItemAttributes(), esperado);
    }

}
