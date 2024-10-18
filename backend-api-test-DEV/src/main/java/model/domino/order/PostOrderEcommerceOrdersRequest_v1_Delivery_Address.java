package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Delivery_Address {
    private String complement;
    private String deliveryReference;
    private Long localityCode;
    private Long number;
    private Long streetCode;
}
