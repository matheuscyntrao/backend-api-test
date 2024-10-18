package model.timeB.rappi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostOrderResponseV1Success {
    @JsonProperty("retail_order_id")
    private String retailOrderId;
}