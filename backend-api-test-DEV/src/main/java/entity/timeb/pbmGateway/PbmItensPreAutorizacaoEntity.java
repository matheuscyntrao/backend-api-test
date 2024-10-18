package entity.timeb.pbmGateway;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PbmItensPreAutorizacaoEntity {
    private String transactionIdentify;
    private Long codeItem;
    private String ean;
    private Long quantityPreAuthorization;
    private BigDecimal priceNetPreAuthorized;
}
