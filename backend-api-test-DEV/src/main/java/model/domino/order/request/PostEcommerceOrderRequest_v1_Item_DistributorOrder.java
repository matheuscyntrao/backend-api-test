package model.domino.order.request;

import lombok.Data;

@Data
public class PostEcommerceOrderRequest_v1_Item_DistributorOrder {
    private Long distributionCenter;
    private Long distributorOrderNumber;
}
