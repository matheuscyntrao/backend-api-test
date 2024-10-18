package model.domino.order;

import lombok.Data;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Client_Fidelity {
    private Long covenantSubsidiaryCode;
    private Long fidelityAssociateCode;
    private Long fidelityCovenantCode;
    private String fidelityRegistration;
}
