package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subsidiary {
    private Address address;
    private String cnpj;
    private String friendlyName;
    private String phoneNumber;
    private String sibsidiaryId;
    private String subsidiaryName;
}
