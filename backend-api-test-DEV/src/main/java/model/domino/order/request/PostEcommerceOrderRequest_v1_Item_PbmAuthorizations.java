package model.domino.order.request;

import freemarker.core.BugException;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostEcommerceOrderRequest_v1_Item_PbmAuthorizations {
    private String attendanceDocument;
    private BigDecimal conversionFactor;
    private Long covenantAdministratorCode;
    private BigDecimal covenantValue;
    private Double discountPercentage;
    private BigDecimal discountValue;
    private String programType;
    private String recipientCard;
    private String recipientDocument;
    private String sessionNumber;
    private String transactionId;
    private String transactionUSN;
    private BigDecimal unitaryAcquisitionValue;
}
