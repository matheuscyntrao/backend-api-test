package model.digital.shoppingCart.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Delivery_Locker_LockerReserve {
    private Integer shippingType;
    private Integer shippingTypeCode;
    private String lockerName;
    private String lockerPort;
    private String reserve;
    private String reservePassword;
    private String deliveryDate;
}
