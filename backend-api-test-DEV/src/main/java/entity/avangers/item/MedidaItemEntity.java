package entity.avangers.item;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedidaItemEntity {
    private Integer codigoItem;
    private BigDecimal comprimento;
    private BigDecimal largura;
    private BigDecimal altura;
    private BigDecimal volume;
    private BigDecimal peso;
}
