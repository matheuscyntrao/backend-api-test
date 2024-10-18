package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.PaymentEnum;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ShoppingCartResponse_v1_Payment_CovenantPayment {
    private Integer confpgSequenciaCondicao;
    private BigInteger covenantCode;
    private Integer covenantSubsidiaryCode;
    private String nomeConvenio;
    private BigInteger numeroCartaoConvenio;
    private BigInteger numeroCartaoDigitosRestantes;
    private Integer numeroCartaoPrimeirosDigitos;
    private String numeroDocumento;
    private BigDecimal paidValueWithThisMethod;
    private Integer paymentConditionCode;
    private PaymentEnum paymentEnum;
}
