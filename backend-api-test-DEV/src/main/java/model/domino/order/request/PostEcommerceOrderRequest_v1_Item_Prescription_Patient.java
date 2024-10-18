package model.domino.order.request;

import lombok.Data;

@Data
public class PostEcommerceOrderRequest_v1_Item_Prescription_Patient {
    private Long age;
    private String birthDate;
    private String gender;
    private String name;
}
