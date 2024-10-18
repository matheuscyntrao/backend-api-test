package entity.timeb.pbmGateway;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PbmItensAutorizacaoEntity {
    private String identificadorTransacao;
    private Long panvelCode;
    private String ean;
    private Long quantityAuthorized;
    private BigDecimal authorizedCovenantValue;
}
