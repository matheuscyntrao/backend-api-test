package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostAutorizacaoResponse_v1_formaPagamento {
    private BigDecimal authorizationCovenantValue;
    private String beneficiaryCard;
    private Long covenantCode;
    private Long paymentConditionCode;
    private Long paymentFormCode;
    private Long paymentFormSequence;
    private Long subsidiaryCovenantCode;
}
