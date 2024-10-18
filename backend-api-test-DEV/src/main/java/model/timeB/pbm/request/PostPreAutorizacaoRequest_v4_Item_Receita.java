package model.timeB.pbm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostPreAutorizacaoRequest_v4_Item_Receita {
    private Integer quantidadeReceita;
    private String dataReceita;
    private String tipoProfissional;
    private Integer codigoProfissional;
    private String ufProfissional;
    private String nomePaciente;
}
