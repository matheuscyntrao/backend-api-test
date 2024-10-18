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
public class PostEpharmaPreAutorizacaoResponse_v4_DesvioFluxo {
    private Long codigoItem;
    private String ean;
    private String desvioFluxo;
    private String textoInformativo;
}
