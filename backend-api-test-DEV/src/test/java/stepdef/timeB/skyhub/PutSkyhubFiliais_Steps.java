package stepdef.timeB.skyhub;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.gson.Gson;
import model.timeB.skyhub.request.Subsidiary_Store;
import model.timeB.skyhub.response.Subsidiary;
import service.timeB.skyhub.Skyhub;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class PutSkyhubFiliais_Steps {

    @Dado("possuo dados para Skuhub - v1 - PutFiliais:")
    public void possuo_dados_para_skuhub_v1_put_filiais(Map<String, String> dataTable) throws JsonProcessingException {
        String body = Util.alteraCampoJson(Cache.chamadas.get(Util.rota.apply(Skyhub.GET_FILIAIS_CODE)).getServiceResponse().getBody(),dataTable.get("field"), dataTable.get("value") );
        Subsidiary subsidiary = CucumberUtils.getObjectBodyFromJson(body, Subsidiary.class);
        Subsidiary_Store subsidiary_store = Subsidiary_Store.builder().store(subsidiary).build();
        BuilderRequest.body.accept(Util.rota.apply(Skyhub.PUT_FILIAL), subsidiary_store);
    }

    @E("possuo dados para Skyhub - v1 - PutFiliais path:")
    public void possuo_dados_para_skyhub_v1_put_filiais_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Skyhub.PUT_FILIAL), dataTable);
    }

    @Quando("executo Skyhub - v1 - PutFiliais")
    public void executo_skyhub_v1_put_filiais() {
        Skyhub.putFiliais.run();
    }

    @Entao("sistema processa Skyhub - v1 - PutFiliais:")
    public void sistema_processa_skyhub_v1_put_filiais(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Skyhub.PUT_FILIAL)).getServiceResponse()
                , String.class
        );
    }
}