package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String complement;
    private Long latitude;
    private Long longitude;
    private String neiighborhood;
    private Long number;
    private String state;
    private String street;
    private String streetType;
    private String zipcode;
}
