package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_Pacientes {
    private Integer codigoPaciente;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private Boolean titular;
}
