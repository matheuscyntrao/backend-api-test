package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMateraFinancialLimitV1Response {
    //Limit account balance.
    private Integer realBalanceLimit;
    //Limit handling inputs
    private Integer monthlyFinancialInjectionLimit;
    //Current account balance
    private Integer realBalance;
    //Maximum credit amount
    private Integer maxCreditLimit;
    //Total monthly contribution made
    private Integer  currentMonthlyFinancialInjection;
}
