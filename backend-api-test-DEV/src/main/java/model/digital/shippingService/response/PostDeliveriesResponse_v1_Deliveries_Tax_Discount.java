package model.digital.shippingService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesResponse_v1_Deliveries_Tax_Discount {
    private String description;
}
