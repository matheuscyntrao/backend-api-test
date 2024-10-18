package model.digital.panvelEcommerceBff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSubscriptionFrequencyV1Response {
    private Long periodId;
    private Long orderNumber;
}
