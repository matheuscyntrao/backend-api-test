package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Payment_DebitCardPayment {
    private Integer covenantCode;
    private Integer covenantSubsidiaryCode;
    private Integer paymentSequence;
}
