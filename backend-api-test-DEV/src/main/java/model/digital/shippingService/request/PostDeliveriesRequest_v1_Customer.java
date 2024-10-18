package model.digital.shippingService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesRequest_v1_Customer {
    private Long code;
    private Long covenant;

    public static PostDeliveriesRequest_v1_Customer generate() {
        return PostDeliveriesRequest_v1_Customer.builder()
                .code(123456L)
                .covenant(123456L)
                .build();
    }
}
