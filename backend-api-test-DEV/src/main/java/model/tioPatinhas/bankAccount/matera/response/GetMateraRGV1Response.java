package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMateraRGV1Response {
    private String number;
    //($date(yyyy-mm-dd))
    private String issueDate;
    private String issuer;
    private String state;
}
