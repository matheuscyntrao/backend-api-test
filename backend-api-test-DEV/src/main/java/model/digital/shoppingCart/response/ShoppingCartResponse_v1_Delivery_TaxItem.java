package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import java.math.BigDecimal;

@Data
public class ShoppingCartResponse_v1_Delivery_TaxItem {
    private Long taxCode;
    private Integer quantity;
    private String shippingType;
    private BigDecimal taxValue;
    @Valid
    private ShoppingCartResponse_v1_Delivery_TaxItem_Discount discount;
}
