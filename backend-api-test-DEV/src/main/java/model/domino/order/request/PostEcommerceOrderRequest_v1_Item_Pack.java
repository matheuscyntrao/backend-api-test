package model.domino.order.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostEcommerceOrderRequest_v1_Item_Pack {
    private Long code;
    private BigDecimal extraContribution;
    private BigDecimal itemNumber;
    private String itemType;
    private BigDecimal supplierContribution;
    private BigDecimal tradeContribution;
}
