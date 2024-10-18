package model.digital.panvelEcommerceBff.shipping;

import lombok.Data;
import model.digital.panvelEcommerceBff.shipping.orm.Shipment;

import java.util.List;

@Data
public class GetCartShippingV1Response {
    private List<Shipment> shipments;
}
