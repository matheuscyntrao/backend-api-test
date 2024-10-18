package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShippingDeliveryResponse_v1_MotoboyDelivery {
    private Integer deliveryMethodCode;
    private Integer subsidiary;
    private String shippingType;
    private Integer shippingTypeCode;
    private Integer deadline;
    private String leadTimeUnit;
    private String name;
    private ShippingDeliveryResponse_v1_MotoboyDelivery_RestrictedItem restrictedItems[];
    private ShippingDeliveryResponse_v1_MotoboyDelivery_TaxItem taxItem;
}
