package model.digital.panvelEcommerceBff.payment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchCartPaymentDebitInstallmentsV1Request {
    private Long covenantCode;
    private Long paymentConditionCode;
    private String paymentEnum;
    private Boolean posPayment;
    private BigDecimal valueToPay;
}
