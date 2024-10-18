package model.domino.order.request;

import lombok.Data;

@Data
public class PostEcommerceOrderRequest_v1_Item_Prescription_Buyer_Address {
    private String city;
    private String complement;
    private String neighborhood;
    private Integer number;
    private String street;
    private Integer zipCode;
}
