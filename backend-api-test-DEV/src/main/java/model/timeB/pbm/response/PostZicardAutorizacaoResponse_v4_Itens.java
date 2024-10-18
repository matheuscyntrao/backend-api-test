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
public class PostZicardAutorizacaoResponse_v4_Itens {
    private Long codigoItem;
    private String ean;
    private Integer quantidadeAutorizada;
    private BigDecimal precoLiquidoAutorizado;
    private BigDecimal percDescontoAutorizado;
    private BigDecimal valorDescontoAutorizado;
    private BigDecimal valorConvenioAutorizado;
    private BigDecimal fatorConversaoAutorizado;
    private Boolean statusAutorizacao;
    private String mensagem;
    private BigDecimal precoAquisicaoUnitario;
    private Boolean melhorPrecoPanvel;
}
