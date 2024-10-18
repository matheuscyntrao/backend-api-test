package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMateraAccountDetailV1Response {
    private String accountId;
    private Integer account;
    private Integer branch;
    private GetMateraMobilePhoneV1Response mobilePhone;
}
