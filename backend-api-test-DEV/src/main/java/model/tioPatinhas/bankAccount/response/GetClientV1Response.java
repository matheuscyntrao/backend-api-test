package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetClientV1Response {
    private String birthDate;
    private String email;
    private GetMailAddressV1Response mailAddress;
    private String mother;
    private String name;
    private String socialName;
    private GetTaxIdentifierV1Response taxIdentifier;
}
