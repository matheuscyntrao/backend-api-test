package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class PaymentsResponse_v1_Payment_Link {
    private String rel;
    private String href;
    private String type;
}
