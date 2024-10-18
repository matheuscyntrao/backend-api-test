package model.plataforma.request;

import lombok.Data;

@Data
public class PostPaymentHashRequest_v1_CreditCard {
    private Long cardId;
    private Integer installmentType;
    private Integer installments;
}
