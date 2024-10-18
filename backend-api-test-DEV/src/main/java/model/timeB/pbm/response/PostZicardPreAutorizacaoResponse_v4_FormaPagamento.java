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
public class PostZicardPreAutorizacaoResponse_v4_FormaPagamento {
    private Long codigoFilialConvenio;
    private Long codigoConvenio;
    private Long codigoFormaPagamento;
    private Long codigoCondicaoPagamento;
    private Long sequenciaFormaPagamento;
    private BigDecimal valorConvenioPreAutorizado;
}
