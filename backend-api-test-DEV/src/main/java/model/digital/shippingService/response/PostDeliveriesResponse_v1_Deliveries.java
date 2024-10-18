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
public class PostDeliveriesResponse_v1_Deliveries {
    private String code;
    private PostDeliveriesResponse_v1_Deliveries_Deadline deadline;
    private PostDeliveriesResponse_v1_Deliveries_Description description;
    private List<PostDeliveriesResponse_v1_Deliveries_Events> events;
    private List<PostDeliveriesResponse_v1_Deliveries_Items> items;
    private Integer itemsQuantity;
    private List<PostDeliveriesResponse_v1_Deliveries_Routes> routes;
    private PostDeliveriesResponse_v1_Deliveries_Subsidiary subsidiary;
    private PostDeliveriesResponse_v1_Deliveries_Tax tax;

}
