package model.digital.shippingService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesResponse_v1_Deliveries_Events {
    private String event;
}
