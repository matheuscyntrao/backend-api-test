package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class PaymentsResponse_v1_Payment {
    private Integer paymentCode;
    private String paymentDescription;
    private Boolean rearCashPayment;
    private String payment;
    private PaymentsResponse_v1_Payment_Link links[];
}
