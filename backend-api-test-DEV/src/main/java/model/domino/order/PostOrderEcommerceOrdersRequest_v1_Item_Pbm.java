package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item_Pbm {
    private List<PostOrderEcommerceOrdersRequest_v1_Item_Pbm_Authorization> authorizations;
    private String cardNumber;
    private Long pbmCovenantCode;
    private Long pbmCovenantId;
    private Long preAuthorization;
    private String transactionId;
    private BigDecimal transferValue;
    private BigDecimal unitaryAcquisitionValue;
}
