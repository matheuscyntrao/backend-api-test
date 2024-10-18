package model.digital.shoppingCart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentGroupEnum {

    CREDIT_CARD(1),
    DEBIT_CARD(2),
    COVENANT(3);

    private final Integer groupCode;
}
