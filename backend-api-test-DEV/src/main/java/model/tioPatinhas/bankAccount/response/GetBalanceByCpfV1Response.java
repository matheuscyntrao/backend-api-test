package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetBalanceByCpfV1Response {
    private BigDecimal autoInvest;
    private BigDecimal available;
    private BigDecimal availableBalanceForTransactions;
    private BigDecimal blocked;
    private String date;
    private BigDecimal emergencyAidBalance;
    private BigDecimal overdraft;
    private BigDecimal real;
}
