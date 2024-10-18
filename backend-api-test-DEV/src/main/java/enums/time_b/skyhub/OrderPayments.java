package enums.time_b.skyhub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.skyhub.request.OrderRequestPayments;
import model.timeB.skyhub.request.OrderRequestPaymentsSefaz;

@AllArgsConstructor
@Getter
public enum OrderPayments {
    PAGAMENTO_SIMPLES {
        @Override
        public OrderRequestPayments pojo() {
            OrderRequestPaymentsSefaz paymentsSefaz = OrderPaymentsSefaz.PAGAMENTO_SEFAZ_SIMPLES.pojo();
            return OrderRequestPayments.builder()
                    .transactionDate("2000-01-23T04:56:07.000+00:00")
                    .autorizationId("autorization_id")
                    .cardIssuer("card_issuer")
                    .method("method")
                    .description("description")
                    .sefaz(paymentsSefaz)
                    .value(25.0)
                    .parcels(3)
                    .status("status")
                    .build();
        }
    },
    PAGAMENTO_JUROS {
        @Override
        public OrderRequestPayments pojo() {
            OrderRequestPaymentsSefaz paymentsSefaz = OrderPaymentsSefaz.PAGAMENTO_SEFAZ_SIMPLES.pojo();
            return OrderRequestPayments.builder()
                    .transactionDate("2000-01-23T04:56:07.000+00:00")
                    .autorizationId("autorization_id")
                    .cardIssuer("card_issuer")
                    .method("method")
                    .description("description")
                    .sefaz(paymentsSefaz)
                    .value(27.0)
                    .parcels(1)
                    .status("status")
                    .build();
        }
    },
    PAGAMENTO_DESCONTO {
        @Override
        public OrderRequestPayments pojo() {
            OrderRequestPaymentsSefaz paymentsSefaz = OrderPaymentsSefaz.PAGAMENTO_SEFAZ_SIMPLES.pojo();
            return OrderRequestPayments.builder()
                    .transactionDate("2000-01-23T04:56:07.000+00:00")
                    .autorizationId("autorization_id")
                    .cardIssuer("card_issuer")
                    .method("method")
                    .description("description")
                    .sefaz(paymentsSefaz)
                    .value(101.99)
                    .parcels(1)
                    .status("status")
                    .build();
        }
    };

    public abstract OrderRequestPayments pojo();
}