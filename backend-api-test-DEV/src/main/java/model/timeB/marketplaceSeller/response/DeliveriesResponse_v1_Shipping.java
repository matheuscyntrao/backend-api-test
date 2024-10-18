package model.timeB.marketplaceSeller.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class DeliveriesResponse_v1_Shipping {
    private Double shippingCost;
    @Valid
    private DeliveriesResponse_v1_DeliveryTime deliveryTime;
    private String shippingMethodId;
    private String shippingMethodName;
    private String shippingMethodDisplayName;

}

