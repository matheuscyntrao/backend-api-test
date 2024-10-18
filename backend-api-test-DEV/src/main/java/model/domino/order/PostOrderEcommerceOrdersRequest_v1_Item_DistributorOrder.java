package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_DistributorOrder {
    private Long distributionCenter;
    private Long distributorOrderNumber;
}
