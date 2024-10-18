package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTaxIdentifierV1Response {
    private String country;
    private String taxId;
    private String taxIdMasked;
}
