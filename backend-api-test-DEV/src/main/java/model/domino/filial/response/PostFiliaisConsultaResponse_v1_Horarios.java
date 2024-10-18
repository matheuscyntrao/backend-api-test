package model.domino.filial.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFiliaisConsultaResponse_v1_Horarios {
    private String abertura;
    private String fechamento;
    private String aberturaFeriado;
    private String fechamentoFeriado;
}
