package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMateraAccountDataV1Response {
    private String accountHolderId;
    //string($date(yyyy-mm-dd))
    private String dueDate;
    private GetMateraRatesV1Response rates;
    private GetMateraAccountDetailV1Response account;
    private GetMateraClientV1Response client;
    private GetMateraClientV1Response representative;
    private GetMateraEnderecoV1Response billingAddress;
    private String clientType;
    private GetAdditionalDetailsPersonV1Response additionalDetailsPerson;
    private GetAdditionalDetailsCorporateV1Response additionalDetailsCorporate;
    private GetAdditionalDetailsForeignerV1Response additionalDetailsForeigner;
    private Integer accountInternalTypeId;
    private GetMateraFinancialLimitV1Response financialLimit;
    private String accountStatus;
}
