package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Condition {
    private String covenantDescription;
    private Long installmentsNumber;
    private Long paymentConditionCode;
    private String paymentConditionDescription;
}
