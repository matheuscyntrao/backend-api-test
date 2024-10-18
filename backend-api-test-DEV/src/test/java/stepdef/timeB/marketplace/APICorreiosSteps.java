package stepdef.timeB.marketplace;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.entrega.orm.Item;
import model.digital.entrega.v3.request.PostCorreiosRequest;
import model.digital.entrega.v3.response.PostCorreiosResponse;
import service.digital.entrega.Entrega_v3;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class APICorreiosSteps {
    @Dado("possuo dados para Entrega - v3 - Correios:")
    public void possuo_dados_para_entrega_v3_correios(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Entrega_v3.POST_CORREIOS), CucumberUtils.getObjectBody(dataTable, PostCorreiosRequest.class));
    }

    @Dado("possuo dados para Entrega - v3 - Correios itens:")
    public void possuo_dados_para_entrega_v3_correios_itens(DataTable dataTable) throws JsonProcessingException {
        PostCorreiosRequest correiosRequest = Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_CORREIOS)).getServiceSpecs().getObjectBody(PostCorreiosRequest.class);
        correiosRequest.setItens(Arrays.asList(CucumberUtils.getObjectBody(dataTable, Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_CORREIOS)).getServiceSpecs().setBody(correiosRequest);
    }

    @Quando("executo Entrega - v3 - Correios")
    public void executo_entrega_v3_correios() {
        Entrega_v3.postCorreios.run();
    }

    @Entao("sistema processa Entrega - v3 - Correios:")
    public void sistema_processa_entrega_v3_correios(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Entrega_v3.POST_CORREIOS)).getServiceResponse()
                , PostCorreiosResponse[].class
        );
    }
}
