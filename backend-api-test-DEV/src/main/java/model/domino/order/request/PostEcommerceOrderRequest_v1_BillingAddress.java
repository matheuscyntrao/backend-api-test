package model.domino.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEcommerceOrderRequest_v1_BillingAddress {
    private String complement;
    private String deliveryReference;
    private Long localityCode;
    private Long number;
    private Long streetCode;
}
