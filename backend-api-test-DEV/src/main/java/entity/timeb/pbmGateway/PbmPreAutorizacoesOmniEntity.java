package entity.timeb.pbmGateway;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PbmPreAutorizacoesOmniEntity {
    private String transactionIdentify;
    private String nsuPreAuthorization;
    private BigDecimal priceNet;
    private BigDecimal priceNetPreAuthorized;
    private String origem;
}
