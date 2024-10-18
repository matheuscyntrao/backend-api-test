package model.digital.shoppingCart.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.shoppingCart.orm.DigitalPrescription;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatchDigitalDescriptionRequest_v1 {
    private DigitalPrescription digitalPrescription;
}
