package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShippingResponse_v1_Shipment_Link {
    private String rel;
    private String href;
    private String title;
    private String type;
}
