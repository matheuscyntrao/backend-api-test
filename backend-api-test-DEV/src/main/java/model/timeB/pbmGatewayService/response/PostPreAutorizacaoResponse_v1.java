package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPreAutorizacaoResponse_v1 {
    private String programSequence;
    private String cardBeneficiary;
    private String codeAdminCovenant;
    private PostPreAutorizacaoResponse_v1_deviationFlux deviationFlux;
    private PostPreAutorizacaoResponse_v1_formPayment formPayment;
    private List<PostPreAutorizacaoResponse_v1_itemsApproved> itemsApproved;
    private List<PostPreAutorizacaoResponse_v1_itemsRejected> itemsRejected;
    private String nsuPreAuthorization;
    private String numberSession;
    private List<PostPreAutorizacaoResponse_v1_patients> patients;
    private Boolean prescriptionRequest;
    private Boolean statusPreAuthorization;
    private PostPreAutorizacaoResponse_v1_textTermsOptin textTermsOptin;
    private String transactionIdentify;

}
