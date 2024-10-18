package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingCartResponse_v1_CartTotals_DeliveryTotal {
    private BigDecimal value;
    private String description;
}
