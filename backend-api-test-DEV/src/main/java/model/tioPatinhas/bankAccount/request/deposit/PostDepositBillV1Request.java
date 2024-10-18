package model.tioPatinhas.bankAccount.request.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDepositBillV1Request {
    private BigDecimal ammount;
    private String document;
    private String shopperStatement;
}
