package model.digital.shoppingCart.response;

import lombok.Data;

import java.util.List;

@Data
public class ShippingDeliveryResponse_v1_PacDelivery {
    private Integer deliveryMethodCode;
    private Long subsidiary;
    private String shippingType;
    private Integer shippingTypeCode;
    private Integer deadline;
    private String leadTimeUnit;
    private List<ShippingDeliveryResponse_v1_PacDelivery_RestrictItems> restrictedItems;
    private ShippingDeliveryResponse_v1_PacDelivery_TaxItem taxItem;
}
