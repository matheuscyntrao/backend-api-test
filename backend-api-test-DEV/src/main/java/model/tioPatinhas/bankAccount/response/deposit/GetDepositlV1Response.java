package model.tioPatinhas.bankAccount.response.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.tioPatinhas.bankAccount.response.GetMobilePhoneV1Response;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDepositlV1Response {
        private String boletoUrl;
        private String dueDate;
        private String externalIdentifier;
        private String financialStatus;
        private String transactionId;
        private String typeableLine;
}
