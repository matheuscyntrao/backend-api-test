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
public class PostEpharmaPreAutorizacaoResponse_v4_Item {
    private Long codigoItem;
    private String ean;
    private Integer quantidadePreAutorizada;
    private BigDecimal precoLiquidoPreAutorizado;
    private BigDecimal percDescontoPreAutorizado;
    private BigDecimal valorDescontoPreAutorizado;
    private BigDecimal valorConvenioPreAutorizado;
    private BigDecimal fatorConversaoAutorizado;
    private Boolean statusPreAutorizacao;
    private String mensagem;
    private Boolean melhorPrecoPanvel;
}
