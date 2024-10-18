package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.ChannelEnum;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Payment {
    @Valid
    private ShoppingCartResponse_v1_Payment_CashPayment cashPayment;
    @Valid
    private ShoppingCartResponse_v1_Payment_BankslipPayment bankSlipPayment;
    @Valid
    private ShoppingCartResponse_v1_Payment_CreditCardPayment creditCardPayment;
    @Valid
    private ShoppingCartResponse_v1_Payment_DebitCardPayment debitCardPayment;
    @Valid
    private ShoppingCartResponse_v1_Payment_InstallmentDebitPayment installmentDebitPayment;
    @Valid
    private ShoppingCartResponse_v1_Payment_CovenantPayment covenantPayment;
}
