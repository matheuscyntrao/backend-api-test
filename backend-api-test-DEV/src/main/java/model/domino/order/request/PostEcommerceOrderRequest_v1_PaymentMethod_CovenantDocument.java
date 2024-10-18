package model.domino.order.request;

import lombok.Data;

@Data
public class PostEcommerceOrderRequest_v1_PaymentMethod_CovenantDocument {
    private Long documentTypeCode;
    private String inputValue;
}
