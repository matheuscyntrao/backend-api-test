package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingCartResponse_v1_Delivery_TaxItem_Discount {
    private String origin;
    private BigDecimal dealPrice;
}
