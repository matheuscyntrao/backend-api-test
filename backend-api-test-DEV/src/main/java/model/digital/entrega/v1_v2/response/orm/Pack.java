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
public class Pack {
    private Integer codPack;
    private String descricao;
    private String tipoSelo;
    private Integer qtd;
    private BigDecimal precoDe;
    private BigDecimal precoPor;
    private Float percentualDesconto;
    private Integer estoque;
    private Restricao restricao;
}
