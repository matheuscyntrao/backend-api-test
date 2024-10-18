package model.digital.panvelEcommerceBff.shipping.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    private String description;
    private String name;
    private String shipmentId;
    private String type;
}
