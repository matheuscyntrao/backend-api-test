package model.digital.panvelEcommerceBff.subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchCartItemSubscriptionV1Request {
    private Long  panvelCode;
    private Long periodInMonths;
}
