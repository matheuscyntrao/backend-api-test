package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Item_Discount_Detail_Covenant {
    private Long code;
    private Double discountPercentage;
    private String description;
}
