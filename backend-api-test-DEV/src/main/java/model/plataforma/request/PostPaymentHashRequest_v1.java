package model.plataforma.request;

import lombok.Data;

@Data
public class PostPaymentHashRequest_v1 {
    private Boolean autoConfirmation;
    private Integer channel;
    private String customerId;
    private PostPaymentHashRequest_v1_CreditCard creditCard;
    private Integer filial;
    private Boolean isAnalyzer;
    private PostPaymentHashRequest_v1_Order order;
    private String origin;

}
