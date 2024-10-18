package stepdef.plataforma.paymentGateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.plataforma.request.PostKondutoRequest_v1;
import model.plataforma.response.PostKondutoResponse_v1;
import service.plataforma.paymentGateway.Paymentsv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class PostKondutoSteps {
    @Dado("possuo dados para Plataforma - Payment - Konduto:")
    public void possuo_dados_para_plataforma_payment_konduto(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Paymentsv1.POST_KONDUTO), CucumberUtils.getObjectBody(dataTable, PostKondutoRequest_v1.class));
    }

    @Quando("executo Plataforma - Payment - Konduto")
    public void executo_plataforma_payment_konduto() {
        Paymentsv1.postKonduto.run();
    }

    @Entao("sistema processa Plataforma - Payment - Konduto:")
    public void sistema_processa_plataforma_payment_konduto(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_KONDUTO)).getServiceResponse()
                , PostKondutoResponse_v1.class
        );
    }


}
