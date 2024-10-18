package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPreAutorizacaoResponse_v1_itemsApproved {
    private Long authorizedConversionFactor;
    private Boolean bestPricePanvel;
    private String ean;
    private String identifier;
    private String message;
    private Long panvelItem;
    private BigDecimal priceNetPreAuthorized;
    private Double percentageDiscountPreAuthorized;
    private Number priceLiquidoPreAuthorized;
    private Long quantityPreAuthorization;
    private Boolean statusPreAuthorization;
    private Number valueCovenantPreAuthorized;
    private BigDecimal valueDiscountPreAuthorized;
}
