package model.timeB.skyhub.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestItems {
    private String id;
    private Integer qty;
    @JsonProperty("original_price")
    private Double originalPrice;
    @JsonProperty("special_price")
    private Double specialPrice;
}