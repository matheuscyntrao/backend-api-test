package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShippingDeliveryResponse_v1 {
    private String shoppingCartId;
    private Integer shipment;
    private ShippingDeliveryResponse_v1_MotoboyDelivery motoboyDelivery;
    private ShippingDeliveryResponse_v1_PacDelivery pacDelivery;
}
