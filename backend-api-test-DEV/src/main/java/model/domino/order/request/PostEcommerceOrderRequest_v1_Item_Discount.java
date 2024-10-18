package model.domino.order.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostEcommerceOrderRequest_v1_Item_Discount {
    private PostEcommerceOrderRequest_v1_Item_Discount_Cash cashCovenant;
    private String discountOrigin;
    private Double discountPercentage;
    private String discountType;
    private BigDecimal discountValue;
    private Integer transactionId;
}
