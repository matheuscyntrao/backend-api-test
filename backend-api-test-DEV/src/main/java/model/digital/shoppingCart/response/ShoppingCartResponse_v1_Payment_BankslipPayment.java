package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class ShoppingCartResponse_v1_Payment_BankslipPayment {
    @Valid
    private ShoppingCartResponse_v1_Payment_BankslipPayment_Condition condition;
    private Integer paymentSubsidiary;
    private Integer paymentCommercialEntityCode;
}
