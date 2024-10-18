package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMateraClientV1Response {
    private String name;
    private String socialName;
    private GetMateraTaxIdentifierV1Response taxIdentifier;
    private String email;
    private String mother;
    private String birthDate;
    private GetMateraEnderecoV1Response mailAddress;
    private GetMateraDocumentV1Response documents[];
    private GetMateraMobilePhoneV1Response mobilePhone;
}
