package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DebitCardPayment {
    private Long covenantCode;
    private Long covenantSubsidiaryCode;
    private BigDecimal paidValueWithThisMethod;
    private String paymentEnum;
    private Long paymentSequence;
}
