package model.timeB.pbm.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PreAutorizacaoResponse_v4_Item {
    private Long codigoItem;
    private String ean;
    private Short quantidadePreAutorizada;
    private BigDecimal precoLiquidoPreAutorizado;
    private BigDecimal percDescontoPreAutorizado;
    private BigDecimal valorDescontoPreAutorizado;
    private Boolean statusPreAutorizacao;
    private String mensagem;
    private BigDecimal valorConvenioPreAutorizado;
    private BigDecimal fatorConversaoAutorizado;
    private Boolean melhorPrecoPanvel;
}
