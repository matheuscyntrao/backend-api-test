package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostZicardPreAutorizacaoResponse_v4_DesvioFluxo {
    private Long codigoItem;
    private String ean;
    private String desvioFluxo;
    private Boolean textoInformativo;
}
