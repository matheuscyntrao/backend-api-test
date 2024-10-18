package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetOrderQueueResponsePayments {
    @JsonProperty("transaction-date")
    private String transactionDate;
    @JsonProperty("autorization_id")
    private String autorizationId;
    @JsonProperty("card_issuer")
    private String cardIssuer;
    private String method;
    private String description;
    private GetOrderQueueResponsePaymentsSefaz sefaz;
    private Double value;
    private Integer parcels;
    private String status;
}