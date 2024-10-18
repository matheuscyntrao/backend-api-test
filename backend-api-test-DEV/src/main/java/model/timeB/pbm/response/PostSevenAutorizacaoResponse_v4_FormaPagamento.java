package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostSevenAutorizacaoResponse_v4_FormaPagamento {
    private Long codigoFilialConvenio;
    private Long codigoConvenio;
    private Long codigoFormaPagamento;
    private Long codigoCondicaoPagamento;
    private Long sequenciaFormaPagamento;
    private BigDecimal valorConvenioAutorizado;
    private String cartaoBeneficiario;
}
