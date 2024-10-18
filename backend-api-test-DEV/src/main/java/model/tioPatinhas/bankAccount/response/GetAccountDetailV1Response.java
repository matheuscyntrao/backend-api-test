package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountDetailV1Response {
        private Integer account;
        private String accountId;
        private Integer branch;
        private GetMobilePhoneV1Response mobilePhone;
}
