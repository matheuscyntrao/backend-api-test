package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.tioPatinhas.bankAccount.response.deposit.GetDocumentV1Response;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDraweeV1Response {
    private String name;
    private GetDocumentV1Response taxIdentifier;
}
