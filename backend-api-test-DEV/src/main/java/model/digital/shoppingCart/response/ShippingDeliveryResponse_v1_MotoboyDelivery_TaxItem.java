package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ShippingDeliveryResponse_v1_MotoboyDelivery_TaxItem {
    private BigInteger taxCode;
    private Integer quantity;
    private String shippingType;
    private Double taxValue;
}
