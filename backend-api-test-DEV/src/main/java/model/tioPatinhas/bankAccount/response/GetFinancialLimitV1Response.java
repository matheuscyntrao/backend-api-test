package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetFinancialLimitV1Response {
    private Integer currentMonthlyFinancialInjection;
    private Integer maxCreditLimit;
    private Integer monthlyFinancialInjectionLimit;
    private Integer realBalance;
    private Integer realBalanceLimit;
}
