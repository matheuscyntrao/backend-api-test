package model.tioPatinhas.bankAccount.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutBillingAddressV1Request {
    private String city;
    private String complement;
    private String district;
    private String number;
    private String publicPlace;
    private String state;
    private String zipCode;

}
