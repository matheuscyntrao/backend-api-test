package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class ShippingResponse_v1 {
    @Valid
    private ShippingResponse_v1_Shipment shipments[];
}
