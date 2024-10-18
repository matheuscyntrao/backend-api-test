package model.timeB.rappi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderRequestV1Delivery {
    @JsonProperty("delivery_time")
    private String deliveryTime;
    @JsonProperty("departure_time")
    private String departureTime;
}