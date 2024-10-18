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
public class PostFuncionalPreAutorizacaoResponse_v4_Item {
    private String codigoItem;
    private String ean;
    private Integer quantidadePreAutorizada;
    private BigDecimal precoLiquidoPreAutorizado;
    private BigDecimal percDescontoPreAutorizado;
    private BigDecimal valorDescontoPreAutorizado;
    private BigDecimal valorConvenioPreAutorizado;
    private Boolean statusPreAutorizacao;
    private String mensagem;
    private Boolean obrigaReceita;
}
