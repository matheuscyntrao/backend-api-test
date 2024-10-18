package model.digital.panvelEcommerceBff.prescription.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionGet {
    private Boolean holdPrescription;
    private Long itemCode;
    private Long modelCode;
    private Boolean psychotropic;
    private Boolean stripe;
}
