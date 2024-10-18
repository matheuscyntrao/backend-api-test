package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class ShippingPickupResponse_v1 {
    private String shippingType;
    private String shoppingCartId;
    @Valid
    private ShippingPickupResponse_v1_Store stores[];
}
