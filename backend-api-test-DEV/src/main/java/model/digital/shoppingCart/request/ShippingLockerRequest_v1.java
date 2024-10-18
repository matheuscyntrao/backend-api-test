package model.digital.shoppingCart.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ShippingLockerRequest_v1 {
    private BigInteger lockerId;
    private BigInteger orderNumber;
}
