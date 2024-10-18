package model.digital.shoppingCart.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShoppingCartResponse_v1_Delivery_DeliveryMethod_RestrictedItem {
    private Integer itemCode;
    private String restriction;
}
