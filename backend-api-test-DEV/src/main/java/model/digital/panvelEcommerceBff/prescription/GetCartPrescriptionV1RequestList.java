package model.digital.panvelEcommerceBff.prescription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.prescription.orm.PrescriptionGet;
import model.digital.panvelEcommerceBff.prescription.orm.RequiredAnvisa;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCartPrescriptionV1RequestList {
    private PrescriptionGet prescription;
    private RequiredAnvisa requiredAnvisa;
}
