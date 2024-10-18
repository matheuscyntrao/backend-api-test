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
public class PostOrderRequestV1Products {
    private String id;
    @JsonProperty("retail_id")
    private String retailId;
    private Integer quantity;
    private Integer units;
    @JsonProperty("units_type")
    private String unitsType;
    private Double value;
}