package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Payment_InstallmentDebitPayment {
    private Integer covenantCode;
    private Integer covenantSubsidiaryCode;
    private Integer paymentSequence;
    private Integer paymentConditionCode;
    private Integer confPaymentConditionCode;
    private Integer confConditionSequence;
    private Integer installments;
}
