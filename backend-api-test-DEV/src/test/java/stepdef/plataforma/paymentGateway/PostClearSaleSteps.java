package stepdef.plataforma.paymentGateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.plataforma.request.PostClearSaleRequest_v1;
import model.plataforma.response.PostClearSaleResponse_v1;
import service.plataforma.paymentGateway.Paymentsv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class PostClearSaleSteps {
    @Dado("possuo dados para Plataforma - Payment - ClearSale:")
    public void possuo_dados_para_plataforma_payment_clear_sale(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Paymentsv1.POST_CLEARSALE), CucumberUtils.getObjectBody(dataTable, PostClearSaleRequest_v1.class));
    }

    @Quando("executo Plataforma - Payment - ClearSale")
    public void executo_plataforma_payment_clear_sale() {
        Paymentsv1.postClearSale.run();
    }

    @Entao("sistema processa Plataforma - Payment - ClearSale:")
    public void sistema_processa_plataforma_payment_clear_sale(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_CLEARSALE)).getServiceResponse()
                , PostClearSaleResponse_v1.class
        );
    }
}
