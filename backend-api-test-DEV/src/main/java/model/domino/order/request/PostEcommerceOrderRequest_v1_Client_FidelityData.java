package model.domino.order.request;

import lombok.Data;

@Data
public class PostEcommerceOrderRequest_v1_Client_FidelityData {
    private Long covenantSubsidiaryCode;
    private Long fidelityAssociateCode;
    private Long fidelityCovenantCode;
    private String fidelityRegistration;
}
