package model.digital.shippingService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesRequest_v1_Address {
    private Integer number;
    private Long placeCode;
    private String zipCode;
    private String enumZipCode;

    public static PostDeliveriesRequest_v1_Address generate() {
        return PostDeliveriesRequest_v1_Address.builder()
                .zipCode("91050001")
                .build();
    }
}
