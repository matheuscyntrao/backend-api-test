package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetOrderQueueResponseShippingAddress {
    private String street;
    @JsonProperty("secondary_phone")
    private String secondaryPhone;
    private String region;
    private String reference;
    private String postcode;
    private String phone;
    private String number;
    private String neighborhood;
    @JsonProperty("full_name")
    private String fullName;
    private String detail;
    private String country;
    private String complement;
    private String city;
}