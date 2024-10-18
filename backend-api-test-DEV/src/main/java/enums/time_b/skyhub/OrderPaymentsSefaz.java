package enums.time_b.skyhub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.skyhub.request.OrderRequestPaymentsSefaz;

@AllArgsConstructor
@Getter
public enum OrderPaymentsSefaz {
    PAGAMENTO_SEFAZ_SIMPLES{
        @Override
        public OrderRequestPaymentsSefaz pojo() {
            return OrderRequestPaymentsSefaz.builder()
                    .idPayment("id_payment")
                    .paymentIndicator("payment_indicator")
                    .idCardIssuer("id_card_issuer")
                    .nameCardIssuer("name_card_issuer")
                    .namePayment("name_payment")
                    .typeIntegration("type_integration")
                    .build();
        }
    };

    public abstract OrderRequestPaymentsSefaz pojo();
}