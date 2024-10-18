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
public class OrderRequestPaymentsSefaz {
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