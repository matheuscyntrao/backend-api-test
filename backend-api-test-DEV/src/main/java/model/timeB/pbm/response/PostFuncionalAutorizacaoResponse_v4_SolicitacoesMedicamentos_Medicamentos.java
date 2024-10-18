package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostFuncionalAutorizacaoResponse_v4_SolicitacoesMedicamentos_Medicamentos {
    private Integer codigoItem;
    private Long ean;
    private String nomeMedicamento;
}
