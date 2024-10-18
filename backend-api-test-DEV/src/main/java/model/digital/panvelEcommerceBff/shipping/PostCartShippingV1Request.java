package model.digital.panvelEcommerceBff.shipping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCartShippingV1Request {
    private String description;
    private String name;
    private String shippingType;
}
