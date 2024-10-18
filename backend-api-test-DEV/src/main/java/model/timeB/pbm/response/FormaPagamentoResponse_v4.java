package model.timeB.pbm.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FormaPagamentoResponse_v4 {
    private Long codigoFilialConvenio;
    private Long codigoConvenio;
    private Long codigoFormaPagamento;
    private Long codigoCondicaoPagamento;
    private BigDecimal valorConvenioPreAutorizado;
    private Long sequenciaFormaPagamento;
}
