package model.domino.order.request;

import lombok.Data;

import java.util.List;

@Data
public class PostEcommerceOrderRequest_v1_Item_Prescription_DigitalPrescription {
    private Long id;
    private String platform;
    private String prescriptionType;
    private String token;
}
