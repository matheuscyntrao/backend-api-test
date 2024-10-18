package model.digital.panvelEcommerceBff._orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartTotals {
    private DeliveryTotal deliveryTotal;
    private Double discounts;
    private Double subtotal;
    private Double total;
    private Integer totalItems;
}

