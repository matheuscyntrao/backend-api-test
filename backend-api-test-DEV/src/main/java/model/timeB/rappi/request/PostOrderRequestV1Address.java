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
public class PostOrderRequestV1Address {
    @JsonProperty("street_address")
    private String streetAddress;
    private String number;
    private String description;
    private String neighborhood;
    private String city;
    private String region;
    @JsonProperty("zip_code")
    private String zipCode;
}