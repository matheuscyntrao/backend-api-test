package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class PaymentsPosResponse_v1_PosPayment_Link {
    private String rel;
    private String href;
    private String type;
}
