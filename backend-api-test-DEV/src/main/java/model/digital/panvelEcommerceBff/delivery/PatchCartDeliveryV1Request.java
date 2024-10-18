package model.digital.panvelEcommerceBff.delivery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchCartDeliveryV1Request {
    private String routeId;
    private String shippingType;
}
