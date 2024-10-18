package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deliveries {
    private DeliveryMethod deliveryMethod;
    private Locker locker;
    private PickupStore pickupStore;
}
