package model.digital.panvelEcommerceBff._orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreAuthorization {
    private String beneficiary;
    private String card;
    private String codeAdmCovenant;
    private String cpf;
}
