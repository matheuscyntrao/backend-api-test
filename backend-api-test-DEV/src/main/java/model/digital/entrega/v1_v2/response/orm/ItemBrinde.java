package model.digital.entrega.v1_v2.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemBrinde {
    private Integer codItem;
    private Integer qtd;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private Float percentualDesconto;
    private String origemDesconto;
    private Integer promocao;
    private Integer filialPromotora;
}
