package entity.marketplaceSeller;

import lombok.Data;

@Data
public class FreightTableEntity {
    private Integer idTabelaFrete;
    private Integer idFaixaCep;
    private Integer idFaixaPeso;
    private Double custoFrete;
    private Integer prazoDias;
}
