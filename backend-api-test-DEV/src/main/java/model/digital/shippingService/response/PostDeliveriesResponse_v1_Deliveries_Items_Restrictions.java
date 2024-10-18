package model.digital.shippingService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesResponse_v1_Deliveries_Items_Restrictions {
    private String restriction;

}
