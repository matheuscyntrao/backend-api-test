package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetBillByTypeablelineV1Response {
    private GetBeneficiaryV1Response beneficiary;
    private GetDraweeV1Response drawee;
    private GetPaymentDetailsV1Response paymentDetails;
    private GetSettingsV1Response settings;
    private String status;
    private String unmatchingValueAuthCode;
}
