package model.digital.panvelEcommerceBff.pickup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchCartPickupV1Request {
    private String pickupPersonCpf;
    private Long subsidiaryCode;
}
