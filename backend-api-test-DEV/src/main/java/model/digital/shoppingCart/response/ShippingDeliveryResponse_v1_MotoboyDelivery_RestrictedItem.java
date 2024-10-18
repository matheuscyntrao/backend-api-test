package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ShippingDeliveryResponse_v1_MotoboyDelivery_RestrictedItem {
        private BigInteger itemCode;
        private String restriction;
}
