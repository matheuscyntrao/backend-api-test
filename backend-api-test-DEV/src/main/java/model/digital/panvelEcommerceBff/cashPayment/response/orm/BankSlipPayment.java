package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankSlipPayment {
    private Condition condition;
    private Long paidValueWithThisMethod;
    private Long paymentCommercialEntityCode;
    private String paymentEnum;
    private Long paymentSubsidiary;
}
