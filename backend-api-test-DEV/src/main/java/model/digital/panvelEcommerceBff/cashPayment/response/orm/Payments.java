package model.digital.panvelEcommerceBff.cashPayment.response.orm;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
    private BankSlipPayment bankSlipPayment;
    private CashPayment cashPayment;
    private CreditCardPayment creditCardPayment;
    private DebitCardPayment debitCardPayment;
    private InstallmentDebitPayment installmentDebitPayment;
}
