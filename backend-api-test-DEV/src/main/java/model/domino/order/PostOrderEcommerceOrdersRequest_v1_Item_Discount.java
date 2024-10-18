package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Discount {
    private PostOrderEcommerceOrdersRequest_v1_Item_Discount_CashCovenant cashCovenant;
    private Long discountOrigin;
    private Double discountPercentage;
    private String discountType;
    private BigDecimal discountValue;
}
