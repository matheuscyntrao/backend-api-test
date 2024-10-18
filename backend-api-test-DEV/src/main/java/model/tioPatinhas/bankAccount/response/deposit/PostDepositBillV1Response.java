package model.tioPatinhas.bankAccount.response.deposit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDepositBillV1Response {
        private String boletoUrl;
        private String dueDate;
        private String externalIdentifier;
        private String financialStatus;
        private String transactionId;
        private String typeableLine;
}
