package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class ShoppingCartResponse_v1_Item_Discount {
    private Double percentage;
    private Double dealPrice;
    @Valid
    private ShoppingCartResponse_v1_Item_Discount_Detail discountDetail;

}
