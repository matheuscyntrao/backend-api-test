package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Prescription {
    private PostOrderEcommerceOrdersRequest_v1_Item_Prescription_Buyer buyer;
    private List<String> catchmentType;
    private PostOrderEcommerceOrdersRequest_v1_Item_Prescription_Covenant covenant;
    private PostOrderEcommerceOrdersRequest_v1_Item_Prescription_DigitalPrescription digitalPrescription;
    private Long employeeCode;
    private Long id;
    private String notificationComplement;
    private String notificationNumber;
    private String notificationState;
    private PostOrderEcommerceOrdersRequest_v1_Item_Prescription_Patient patient;
    private String prescriptionDate;
    private Long prescriptionModelCode;
    private String registrationNumber;
    private String stateAbbreviation;
}
