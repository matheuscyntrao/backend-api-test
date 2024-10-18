package entity.timeb.pbmGateway;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PbmAutorizacaoOmniEntity {
    private String identificadorTransacao;
    private String nsuAuthorization;
    private BigDecimal priceNetAuthorized;
    private BigDecimal authorizedCovenantValue;
}
