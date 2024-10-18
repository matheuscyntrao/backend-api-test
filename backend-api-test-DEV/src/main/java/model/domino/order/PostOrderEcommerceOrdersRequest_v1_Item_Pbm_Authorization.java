package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Pbm_Authorization {
    private String attendanceDocument;
    private Long covenantAdministratorCode;
    private Double discountPercentage;
    private BigDecimal discountValue;
    private String programType;
    private String recipientCard;
    private String recipientDocument;
    private String transactionId;
    private String transactionUSN;
    private BigDecimal unitaryAcquisitionValue;
}
