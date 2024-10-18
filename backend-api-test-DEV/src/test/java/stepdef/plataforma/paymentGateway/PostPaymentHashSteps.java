package stepdef.plataforma.paymentGateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.plataforma.request.*;
import model.plataforma.response.PostPaymentHashResponse_v1;
import service.plataforma.paymentGateway.Paymentsv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;

public class PostPaymentHashSteps {
    @Dado("possuo dados para Plataforma - Payment - Hash:")
    public void possuo_dados_para_plataforma_payment_hash(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH), CucumberUtils.getObjectBody(dataTable, PostPaymentHashRequest_v1.class));
    }

    @Dado("possuo dados para Plataforma - Payment - Hash creditCard:")
    public void possuo_dados_para_plataforma_payment_hash_credit_card(DataTable dataTable) throws JsonProcessingException {
        PostPaymentHashRequest_v1 input = Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().getObjectBody(PostPaymentHashRequest_v1.class);
        input.setCreditCard(CucumberUtils.getObjectBody(dataTable, PostPaymentHashRequest_v1_CreditCard.class));
        Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Plataforma - Payment - Hash order:")
    public void possuo_dados_para_plataforma_payment_hash_order(DataTable dataTable) throws JsonProcessingException {
        PostPaymentHashRequest_v1 input = Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().getObjectBody(PostPaymentHashRequest_v1.class);
        input.setOrder(CucumberUtils.getObjectBody(dataTable, PostPaymentHashRequest_v1_Order.class));
        Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Plataforma - Payment - Hash order antiFraudClient:")
    public void possuo_dados_para_plataforma_payment_hash_order_anti_fraud_client(DataTable dataTable) throws JsonProcessingException {
        PostPaymentHashRequest_v1 input = Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().getObjectBody(PostPaymentHashRequest_v1.class);
        input.getOrder().setAntiFraudClient(CucumberUtils.getObjectBody(dataTable, PostPaymentHashRequest_v1_Order_AntiFraudClient.class));
        Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Plataforma - Payment - Hash order billingAddress:")
    public void possuo_dados_para_plataforma_payment_hash_order_billing_address(DataTable dataTable) throws JsonProcessingException {
        PostPaymentHashRequest_v1 input = Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().getObjectBody(PostPaymentHashRequest_v1.class);
        input.getOrder().setBillingAddress(CucumberUtils.getObjectBody(dataTable, PostPaymentHashRequest_v1_Order_BillingAddress.class));
        Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Plataforma - Payment - Hash order deliveryAddress:")
    public void possuo_dados_para_plataforma_payment_hash_order_delivery_address(DataTable dataTable) throws JsonProcessingException {
        PostPaymentHashRequest_v1 input = Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().getObjectBody(PostPaymentHashRequest_v1.class);
        input.getOrder().setDeliveryAddress(CucumberUtils.getObjectBody(dataTable, PostPaymentHashRequest_v1_Order_DeliveryAddress.class));
        Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Plataforma - Payment - Hash order itens:")
    public void possuo_dados_para_plataforma_payment_hash_order_itens(DataTable dataTable) throws JsonProcessingException {
        PostPaymentHashRequest_v1 input = Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().getObjectBody(PostPaymentHashRequest_v1.class);
        input.getOrder().setItem(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostPaymentHashRequest_v1_Order_Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceSpecs().setBody(input);
    }

    @Quando("executo Plataforma - Payment - Hash")
    public void executo_plataforma_payment_hash() {
        Paymentsv1.postPaymentsHash.run();
    }

    @Entao("sistema processa Plataforma - Payment - Hash:")
    public void sistema_processa_plataforma_payment_hash(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Paymentsv1.POST_PAYMENTS_HASH)).getServiceResponse()
                , PostPaymentHashResponse_v1.class
        );
    }
}
