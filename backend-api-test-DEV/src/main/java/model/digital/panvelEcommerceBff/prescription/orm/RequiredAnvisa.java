package model.digital.panvelEcommerceBff.prescription.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequiredAnvisa {
    private Buyer buyer;
    private Patient patient;
    private Prescriber prescriber;
    private Prescription prescription;
}
