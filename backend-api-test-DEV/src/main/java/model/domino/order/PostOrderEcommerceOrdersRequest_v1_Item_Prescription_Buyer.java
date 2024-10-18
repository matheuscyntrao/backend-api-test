package model.domino.order;

import lombok.Data;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Prescription_Buyer {
    private PostOrderEcommerceOrdersRequest_v1_Item_Prescription_Buyer_Address address;
    private Integer areaCode;
    private String country;
    private String document;
    private String federalUnitry;
    private String generalRegistration;
    private String generalRegistrationIssuingAgency;
    private String name;
    private Long phoneNumber;
}
