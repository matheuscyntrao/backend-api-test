package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Item_Discount_Detail_Promotion {
    private Long subsidiaryCode;
    private Long code;
    private Double discountPercentage;
    private Double dealPrice;
}
