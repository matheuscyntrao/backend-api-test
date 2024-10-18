package mapper.tioPatinhas.bankAccount;

import model.tioPatinhas.bankAccount.response.GetBillByTypeablelineV1Response;
import model.tioPatinhas.bankAccount.response.GetPaymentDetailsV1Response;
import model.tioPatinhas.bankAccount.response.deposit.PostDepositBillV1Response;

public class BillMapper {

    public static GetBillByTypeablelineV1Response mapDepositBillToGetBillTypeableline(PostDepositBillV1Response deposit) {
        return GetBillByTypeablelineV1Response.builder()
                .paymentDetails(
                        getPaymentDetails(deposit)
                )
                .build();
    }

    private static GetPaymentDetailsV1Response getPaymentDetails(PostDepositBillV1Response deposit) {
        return GetPaymentDetailsV1Response.builder()
                .dueDate(deposit.getDueDate())
                .typeableLine(deposit.getTypeableLine())
                .build();
    }
}
