package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class PaymentsResponse_v1 {
    private PaymentsResponse_v1_Payment onlinePayment[];
}
