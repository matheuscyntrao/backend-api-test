package model.digital.shoppingCart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentMethodEnum {
    CASH,
    BANKSLIP,
    CONVENANT_CARD,
    CREDIT,
    DEBIT
}
