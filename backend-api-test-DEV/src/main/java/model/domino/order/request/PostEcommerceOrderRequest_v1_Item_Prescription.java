package model.domino.order.request;

import lombok.Data;

import java.util.List;

@Data
public class PostEcommerceOrderRequest_v1_Item_Prescription {
    private PostEcommerceOrderRequest_v1_Item_Prescription_Buyer buyer;
    private List<String> catchmentType;
    private PostEcommerceOrderRequest_v1_Item_Prescription_Covenant covenant;
    private PostEcommerceOrderRequest_v1_Item_Prescription_DigitalPrescription digitalPrescription;
    private Long employeeCode;
    private Long id;
    private String notificationComplement;
    private String notificationNumber;
    private String notificationState;
    private PostEcommerceOrderRequest_v1_Item_Prescription_Patient patient;
    private Integer prescriptedAmount;
    private String prescriptionDate;
    private Long prescriptionModelCode;
    private Long professionalAddressSequence;
    private Long professionalCode;
    private String professionalType;
    private String registrationNumber;
    private String stateAbbreviation;
}
