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
public class GetOrderQueueResponsePaymentsSefaz {
    @JsonProperty("id_payment")
    private String idPayment;
    @JsonProperty("payment_indicator")
    private String paymentIndicator;
    @JsonProperty("id_card_issuer")
    private String idCardIssuer;
    @JsonProperty("name_card_issuer")
    private String nameCardIssuer;
    @JsonProperty("name_payment")
    private String namePayment;
    @JsonProperty("type_integration")
    private String typeIntegration;
}