package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardPayment {
    private Long confConditionSequence;
    private Long confPaymentConditionCode;
    private Long covenantCode;
    private Long covenantSubsidiaryCode;
    private Long installments;
    private Long paidValueWithThisMethod;
    private Long paymentConditionCode;
    private String paymentEnum;
}
