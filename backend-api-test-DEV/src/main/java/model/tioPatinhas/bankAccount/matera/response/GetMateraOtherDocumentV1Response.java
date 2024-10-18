package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMateraOtherDocumentV1Response {
    private String number;
    private String type;
    //($date(yyyy-mm-dd))
    private String issueDate;
    private String issuer;
}
