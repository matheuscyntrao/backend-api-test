package model.digital.panvelEcommerceBff.cashPayment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchPaymentCashV1Request {
    private BigDecimal givenValue;
    private Long paymentMethodValue;
}
