package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMateraRatesV1Response {
        private BigDecimal yearly;
        private BigDecimal monthly;
        private BigDecimal effectiveCostYearly;
        private BigDecimal effectiveCostMonthly;
        private BigDecimal chargeDay;
        private String chargesPeriod;
}
