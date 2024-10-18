package entity.marketplaceSeller;

import lombok.Data;

@Data
public class ZipCodeRangeEntity {
    private Integer idFaixaCep;
    private Integer cepInicial;
    private Integer cepFinal;
}
