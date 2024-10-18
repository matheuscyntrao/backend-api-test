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
public class PostFuncionalAutorizacaoResponse_v4_Item {
    private Long codigoItem;
    private String ean;
    private Integer quantidadeAutorizada;
    private BigDecimal precoLiquidoAutorizado;
    private BigDecimal percDescontoAutorizado;
    private BigDecimal valorDescontoAutorizado;
    private Boolean statusAutorizacao;
}
