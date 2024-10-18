package model.avengers.item.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItensDimensoesResponse_v3 {
    private Integer codigoItem;
    private BigDecimal peso;
    private BigDecimal volume;
    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal comprimento;
}
