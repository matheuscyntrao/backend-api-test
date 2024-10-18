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
public class PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo {
    private Long codigoItem;
    private String ean;
    private String desvioFluxo;
    private String textoInformativo;
    private PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao politicaAdesao;

}
