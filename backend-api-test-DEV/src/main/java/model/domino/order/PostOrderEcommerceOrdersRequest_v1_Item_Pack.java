package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Pack {
    private Long code;
    private BigDecimal extraContribution;
    private Long itemNumber;
    private String itemType;
    private BigDecimal supplierContribution;
    private BigDecimal tradeContribution;
}
