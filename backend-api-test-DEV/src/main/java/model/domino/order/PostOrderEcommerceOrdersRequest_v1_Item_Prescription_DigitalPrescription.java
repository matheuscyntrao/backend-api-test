package model.domino.order;

import lombok.Data;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Prescription_DigitalPrescription {
    private Long id;
    private String platform;
    private String prescriptionType;
    private String token;
}
