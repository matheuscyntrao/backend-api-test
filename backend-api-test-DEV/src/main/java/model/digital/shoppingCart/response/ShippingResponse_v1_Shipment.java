package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ShippingResponse_v1_Shipment {
    private String shipmentId;
    private String type;
    private String name;
    private String description;
    private ShippingResponse_v1_Shipment_Link links[];
}
