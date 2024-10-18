package model.digital.panvelEcommerceBff.prescription.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    private Long parameterCode;
    private String value;
}
