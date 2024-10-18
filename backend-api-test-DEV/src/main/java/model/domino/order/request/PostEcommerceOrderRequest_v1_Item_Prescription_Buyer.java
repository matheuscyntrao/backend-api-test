package model.domino.order.request;

import lombok.Data;

@Data
public class PostEcommerceOrderRequest_v1_Item_Prescription_Buyer {
    private PostEcommerceOrderRequest_v1_Item_Prescription_Buyer_Address address;
    private Integer areaCode;
    private String country;
    private String document;
    private String federalUnitry;
    private String generalRegistration;
    private String generalRegistrationIssuingAgency;
    private String name;
    private Long phoneNumber;
}
