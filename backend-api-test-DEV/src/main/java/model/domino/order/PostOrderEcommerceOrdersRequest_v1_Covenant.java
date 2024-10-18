package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Covenant {
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
