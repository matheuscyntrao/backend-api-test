package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class PaymentsPosResponse_v1_PosPayment {
    private Integer paymentCode;
    private String paymentDescription;
    private String payment;
    private Integer covenantCode;
    private Integer covenantSubsidiaryCode;
    private Boolean hasPaymentConditions;
    private PaymentsPosResponse_v1_PosPayment_Link links[];
}
