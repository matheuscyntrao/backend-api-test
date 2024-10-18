package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_Pacientes {
    private Integer codigoPaciente;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private Boolean titular;
}
