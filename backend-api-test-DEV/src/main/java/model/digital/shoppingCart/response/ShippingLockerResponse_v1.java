package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShippingLockerResponse_v1 {
    private ShippingLockerResponse_v1_Locker lockers[];
    private Integer shipment;
}
