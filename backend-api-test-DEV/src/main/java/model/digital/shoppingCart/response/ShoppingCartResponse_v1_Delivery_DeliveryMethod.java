package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import java.time.LocalDate;

@Data
public class ShoppingCartResponse_v1_Delivery_DeliveryMethod {
    private Integer deliveryMethodCode;
    private Long subsidiary;
    private String shippingType;
    private Long shippingTypeCode;
    private Integer deadline;
    private String leadTimeUnit;
    private String name;
    @Valid
    private ShoppingCartResponse_v1_Delivery_DeliveryMethod_RestrictedItem restrictedItems[];
    private String subsidiaryOpeningHours;
    @Valid
    private ShoppingCartResponse_v1_Delivery_DeliveryMethod_Routes routes[];
    @Valid
    private ShoppingCartResponse_v1_Delivery_DeliveryMethod_DeliveryRoute deliveryRoute;
    private Boolean consultDistributionCenter;
}
