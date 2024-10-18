package entity.digital.shipping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegrasEntregaEntity {
    private String cep;
    private Long filial_valor_isenta;
    private Long filial_valor_taxa;
    private Long filial_prazo;
    private Long regra_valor_isenta;
    private Long regra_prazo;
    private Long regra_valor_taxa;
}
