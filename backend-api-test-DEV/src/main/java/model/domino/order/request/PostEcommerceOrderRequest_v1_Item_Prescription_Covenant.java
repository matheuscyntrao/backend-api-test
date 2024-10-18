package model.domino.order.request;

import lombok.Data;

import java.util.List;

@Data
public class PostEcommerceOrderRequest_v1_Item_Prescription_Covenant {
    private Long associateCode;
    private String associateRegistration;
    private String cardNumber;
    private Long code;
    private String covenantCardNumber;
    private Long covenantCode;
    private Long covenantSubsidiaryCode;
    private String iinNumber;
    private Long subsidiary;
}
