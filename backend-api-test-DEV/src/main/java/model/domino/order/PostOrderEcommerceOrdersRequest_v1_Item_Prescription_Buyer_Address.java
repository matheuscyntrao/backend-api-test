package model.domino.order;

import lombok.Data;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Prescription_Buyer_Address {
    private String city;
    private String complement;
    private String neighborhood;
    private Integer number;
    private String street;
    private Integer zipCode;
}
