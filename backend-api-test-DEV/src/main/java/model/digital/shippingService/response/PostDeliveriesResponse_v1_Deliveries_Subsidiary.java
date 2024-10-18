package model.digital.shippingService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesResponse_v1_Deliveries_Subsidiary {
    private Long code;
    private String friendlyName;
}
