package model.tioPatinhas.bankAccount.response.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDepositsMadelV1Response {
        private String accountType;
        private List<GetDepositlV1Response> deposits;
}
