package model.digital.panvelEcommerceBff.convenio.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchConvenioCartV1Request {
    private Long codigoDependente;
    private Long condigoConvenio;
    private String matricula;
}
