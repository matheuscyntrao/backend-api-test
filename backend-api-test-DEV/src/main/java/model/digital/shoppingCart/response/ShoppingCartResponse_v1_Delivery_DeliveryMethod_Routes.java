package model.digital.shoppingCart.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Delivery_DeliveryMethod_Routes {
    private String routeId;
    private Long routeCode;
    private String startDate;
    private String finishDate;
}
