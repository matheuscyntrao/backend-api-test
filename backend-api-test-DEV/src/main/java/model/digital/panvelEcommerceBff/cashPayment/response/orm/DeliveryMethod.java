package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryMethod {
    private Boolean consultDistributionCenter;
    private Long deadLine;
    private Long deliveryMethodCode;
    private DeliveryRoute deliveryRoute;
    private String leadTimeUnit;
    private String name;
    private List<RestrictedItems> restrictedItems;
    private List<Routes> routes;
    private String shippingType;
    private Long shippingTypeCode;
    private Long subsidiary;
    private String sibsidiaryOpeningHours;
    private TaxItem taxItem;
}
