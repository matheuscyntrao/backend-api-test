package model.timeB.pbm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostPreAutorizacaoRequest_v4_Item {
    private Long codigoItem;
    private String ean;
    private Integer quantidadeSolicitada;
    private BigDecimal precoBruto;
    private BigDecimal precoLiquido;
    private Boolean respostaOperador;
    private PostPreAutorizacaoRequest_v4_Item_Receita receita;
}
