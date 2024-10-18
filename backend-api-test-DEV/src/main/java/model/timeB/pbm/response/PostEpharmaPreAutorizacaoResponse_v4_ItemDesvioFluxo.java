package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo {
    private Long codigoItem;
    private String ean;
    private String desvioFluxo;
    private String textoInformativo;
    private PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao politicaAdesao;
}
