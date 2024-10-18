package model.digital.panvelEcommerceBff.shoppingCart.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    private String patientName;
    private String prescriptionData;
    private Long professionalCode;
    private String professionalType;
    private String ufProfessional;
}
