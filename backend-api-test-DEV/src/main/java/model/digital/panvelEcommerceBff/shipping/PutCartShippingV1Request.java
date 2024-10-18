package model.digital.panvelEcommerceBff.shipping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutCartShippingV1Request {
    private String description;
    private String name;
    private String shippingType;
}
