package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.ChannelEnum;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_CartTotals {
    private BigDecimal subtotal;
    @Valid
    private ShoppingCartResponse_v1_CartTotals_DeliveryTotal deliveryTotal;
    private BigDecimal discounts;
    private BigDecimal total;
}
