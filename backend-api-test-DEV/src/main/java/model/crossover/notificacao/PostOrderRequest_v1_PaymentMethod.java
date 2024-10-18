package model.crossover.notificacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderRequest_v1_PaymentMethod {
    private String paymentMethodDescription;
    private String paymentType;
    private BigDecimal value;
    private Integer paymentMethodSequence;
    private Integer paymentConditionCode;
    private Integer paymentConditionSequence;
    private Long covenantSubsidiaryCode;
    private Long covenantCode;
    private List<String> covenantDocuments;
    private String transactionUSN;
    private String authorizationNumber;
    private Long cardId;
    private String nitEsitef;
    private String cardHash;
    private Integer authorizerId;
    private Integer installmentType;
    private Integer installments;
    private Integer businessPaperTypeCode;
}
