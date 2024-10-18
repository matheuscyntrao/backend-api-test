package model.avengers.mostruario.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItensListaRequest_v3_Convenio {
    private Integer codigoConvenio;
    private String matricula;
    private Integer codigoDependente;
}
