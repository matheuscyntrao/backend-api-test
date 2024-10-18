package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddress {
    private Long addressCode;
    private Long addressNumber;
    private String city;
    private Long cityCode;
    private String neighborhood;
    private String state;
    private String street;
    private Long streetCode;
    private String streetType;
    private String zipCode;
}
