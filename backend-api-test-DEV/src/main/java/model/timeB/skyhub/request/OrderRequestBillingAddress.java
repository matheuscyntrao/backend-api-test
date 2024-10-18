package model.timeB.skyhub.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestBillingAddress {
    private String street;
    private Integer number;
    private String detail;
    private String neighborhood;
    private String city ;
    private String region;
    private String country;
    private String postcode;
}