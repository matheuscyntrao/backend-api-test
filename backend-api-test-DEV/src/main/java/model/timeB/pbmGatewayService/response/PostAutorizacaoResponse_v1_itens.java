package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostAutorizacaoResponse_v1_itens {
    private Boolean authorizationStatus;
    private Long authorizedConversionFactor;
    private BigDecimal authorizedCovenantValue;
    private BigDecimal authorizedDiscountValue;
    private Boolean bestPricePanvel;
    private String ean;
    private String identifier;
    private String message;
    private Long panvelCode;
    private Double percentageDiscountAuthorized;
    private BigDecimal priceNetAuthorized;
    private BigDecimal priceUnit;
    private Long quantityAuthorized;
}
