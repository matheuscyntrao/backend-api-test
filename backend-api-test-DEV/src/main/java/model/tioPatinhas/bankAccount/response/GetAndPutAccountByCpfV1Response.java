package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAndPutAccountByCpfV1Response {
    private GetAccountDetailV1Response account;
    private String accountStatus;
    private GetBillingAddressV1Response billingAddress;
    private GetClientV1Response client;
    private GetFinancialLimitV1Response financialLimit;
}
