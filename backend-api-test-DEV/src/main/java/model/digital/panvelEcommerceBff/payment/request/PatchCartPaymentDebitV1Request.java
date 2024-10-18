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
public class PatchCartPaymentDebitV1Request {
    private Long covenantCode;
    private String paymentEnum;
    private BigDecimal valueToPay;
}
