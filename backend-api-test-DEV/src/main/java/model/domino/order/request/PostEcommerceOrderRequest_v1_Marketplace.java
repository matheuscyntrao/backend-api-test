package model.domino.order.request;

import lombok.Data;

@Data
public class PostEcommerceOrderRequest_v1_Marketplace {
    private Long hubId;
    private Long id;
    private String orderCode;
}
