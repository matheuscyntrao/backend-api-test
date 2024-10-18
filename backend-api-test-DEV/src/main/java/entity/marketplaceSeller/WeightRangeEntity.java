package entity.marketplaceSeller;

import lombok.Data;

@Data
public class WeightRangeEntity {
    private Integer idFaixaPeso;
    private Double pesoInicial;
    private Double pesoFinal;
    private Integer codigoDoItem;
    private Integer multiplicadorQtd;
}
