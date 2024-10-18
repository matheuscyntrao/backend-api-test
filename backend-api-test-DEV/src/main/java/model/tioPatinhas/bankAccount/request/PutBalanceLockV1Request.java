package model.tioPatinhas.bankAccount.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutBalanceLockV1Request {
    private BigDecimal amount;
    private String document;
}
