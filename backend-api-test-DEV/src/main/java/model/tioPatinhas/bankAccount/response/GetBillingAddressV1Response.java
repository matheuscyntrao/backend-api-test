package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetBillingAddressV1Response {
    private String city;
    private String complement;
    private String country;
    private String district;
    private String number;
    private String state;
    private String zipCode;
    private String address;
}
