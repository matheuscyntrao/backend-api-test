package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Payment_BankslipPayment_Condition {
    private Integer paymentConditionCode;
    private String paymentConditionDescription;
    private String covenantDescription;
    private Integer installmentsNumber;
}
