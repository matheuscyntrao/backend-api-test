package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.PaymentEnum;

import java.math.BigDecimal;

@Data
public class ShoppingCartResponse_v1_Payment_CashPayment {
    private BigDecimal paidValueWithThisMethod;
    private PaymentEnum paymentEnum;
    private BigDecimal givenValueByCustomer;
    private BigDecimal changeValue;
}
