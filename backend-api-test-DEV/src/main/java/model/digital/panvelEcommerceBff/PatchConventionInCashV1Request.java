package model.digital.panvelEcommerceBff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchConventionInCashV1Request {
    private Long codigoDependente;
    private Long condigoConvenio;
    private String matricula;
}
