package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Payment_CreditCardPayment {
    private Integer paymentConditionCode;
    private Integer confPaymentConditionCode;
    private Integer confConditionSequence;
    private Integer covenantSubsidiaryCode;
    private Long covenantCode;
    private Integer installments;
}
