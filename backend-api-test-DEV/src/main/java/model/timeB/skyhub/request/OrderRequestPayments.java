package model.timeB.skyhub.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestPayments {
    @JsonProperty("transaction_date")
    private String transactionDate;
    @JsonProperty("autorization_id")
    private String autorizationId;
    @JsonProperty("card_issuer")
    private String cardIssuer;
    private String method;
    private String description;
    private OrderRequestPaymentsSefaz sefaz;
    private Double value;
    private Integer parcels;
    private String status;
}