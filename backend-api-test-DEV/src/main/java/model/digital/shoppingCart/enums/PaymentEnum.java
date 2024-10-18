package model.digital.shoppingCart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum PaymentEnum {

    CASH("DINHEIRO", 32, null),
    CHECK("CHEQUE", 33, null),
    CARD("CARTÃO", 34, PaymentGroupEnum.CREDIT_CARD),
    PRE_DATED_CHECK("CHEQUE PRE DATADO", 35, null),
    COVENANT("CONVENIO", 36, PaymentGroupEnum.COVENANT),
    CASH_PAYMENT("A VISTA", 37, null),
    DEFERRED_PAYMENT("A PRAZO", 38, null),
    RETIRED("APOSENTADO", 39, null),
    TICKET("TICKET", 40, null),
    ENTERPRISE_CARD("EMPRESA CARTAO", 41, null),
    DEBIT_CARD("CARTAO DE DEBITO", 42, PaymentGroupEnum.DEBIT_CARD),
    PBMS("PBMS", 43, null),
    INSTALLMENT_DEBIT_CARD("CARTÃO DE DEBITO PARCELADO", 44, PaymentGroupEnum.DEBIT_CARD),
    INSTALLMENT_CREDIT_CARD("CARTÃO DE CREDITO PARCELADO", 45, PaymentGroupEnum.CREDIT_CARD),
    FIDELITY_REDEEM("RESGATE FIDELIDADE", 46, PaymentGroupEnum.COVENANT),
    VOUCHER("VOUCHER", 48, null),
    BANK_SLIP("BOLETO BANCARIO", 49, null),
    UNIQUE_PAYMENT_ONLINE_CARD("CARTAO ONLINE A VISTA", 50, PaymentGroupEnum.CREDIT_CARD),
    INSTALLMENT_ONLINE_CARD("CARTAO ONLINE PARCELADO", 51, PaymentGroupEnum.CREDIT_CARD),
    CREDIT_BY_RETURN("CREDITO POR DEVOLUCAO", 52, null),
    POS_TELE_DEBIT_CARD("CARTAO DEBITO POS TELE", 53, PaymentGroupEnum.DEBIT_CARD),
    UNIQUE_PAYMENT_TELE_POS_CARD("CARTAO POS TELE A VISTA", 54, PaymentGroupEnum.CREDIT_CARD),
    INSTALLMENT_POS_TELE_CARD("CARTAO POS TELE PARCELADO", 55, PaymentGroupEnum.CREDIT_CARD),
    PAYPAL("PAYPAL", 56, null),
    ALO_IN_STORE_PAYMENT("ALO PAGAMENTO NA LOJA", 57, null),
    ACERTO_PHARMACUS("ACERTO PHARMACUS", 99, null);

    private static final Map<Integer, PaymentEnum> payments;

    static {
        payments = Collections.unmodifiableMap(Stream.of(PaymentEnum.values())
                .collect(Collectors.toMap(PaymentEnum::getCode, paymentEnum -> paymentEnum)));
    }

    private final String name;
    private final Integer code;
    private final PaymentGroupEnum paymentGroup;

    public static PaymentEnum getPaymentByCode(Integer paymentCode) {
        return payments.get(paymentCode);
    }
}
