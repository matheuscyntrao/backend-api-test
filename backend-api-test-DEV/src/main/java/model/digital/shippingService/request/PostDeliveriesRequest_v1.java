package model.digital.shippingService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesRequest_v1 {
    private PostDeliveriesRequest_v1_Address address;
    private PostDeliveriesRequest_v1_Customer customer;
    private String date;
    private List<PostDeliveriesRequest_v1_Items> items;
    private Long operator;
    private String origin;
}
