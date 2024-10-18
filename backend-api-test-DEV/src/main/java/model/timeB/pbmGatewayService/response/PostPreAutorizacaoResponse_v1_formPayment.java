package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPreAutorizacaoResponse_v1_formPayment {
    private Long codeConditionPayment;
    private Long codeCovenant;
    private Long codeFormPayment;
    private Long sequenceFormPayment;
    private Number valueCovenantPreAuthorized;
}
