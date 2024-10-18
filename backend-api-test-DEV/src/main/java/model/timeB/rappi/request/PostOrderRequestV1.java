package model.timeB.rappi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderRequestV1 {
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("total_value")
    private Double totalValue;
    @JsonProperty("retail_store_id")
    private String retailStoreId;
    @JsonProperty("order_preference")
    private String orderPreference;
    private PostOrderRequestV1Client client;
    private PostOrderRequestV1Delivery delivery;
    private PostOrderRequestV1Address address;
    private List<PostOrderRequestV1Products> products;
}