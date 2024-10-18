package model.plataforma.response;

import lombok.Data;

import java.util.List;

@Data
public class PostPaymentHashResponse_v1 {
    private String transactionId;
    private String createdDate;
    private String externalOrderId;
    private String gatewayName;
    private Integer filial;
    private String nit;
    private String antiFraudRecommendation;
    private String transactionStatus;
    private String transactionStatusDescription;
    private String esitefUSN;
    private String sitefUSN;
    private String hostUSN;
    private Integer merchantUSN;
    private String authorizationNumber;
    private List<PostPaymentHashResponse_v1_Links> links;
}
