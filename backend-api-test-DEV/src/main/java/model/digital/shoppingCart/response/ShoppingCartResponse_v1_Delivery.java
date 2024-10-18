package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.ChannelEnum;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Delivery {
    @Valid
    private ShoppingCartResponse_v1_Delivery_TaxItem taxItem;
    @Valid
    private ShoppingCartResponse_v1_Delivery_DeliveryMethod deliveryMethod;
    @Valid
    private ShoppingCartResponse_v1_Delivery_Locker locker;
    @Valid
    private ShoppingCartResponse_v1_Delivery_PickupStore pickupStore;
    private String code;
    private String friendlyName;
    private String method;
    private String opens;
    private String closes;
    private String nextOpeningTime;
    private String phone;
}
