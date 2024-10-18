package model.tioPatinhas.bankAccount.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutAccountUpdateV1Request {
    private PutBillingAddressV1Request billingAddress;
    private String email;
    private String name;
    private String phoneNumber;
}
