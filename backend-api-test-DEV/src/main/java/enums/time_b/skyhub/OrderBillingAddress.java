package enums.time_b.skyhub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.skyhub.request.OrderRequestBillingAddress;

@AllArgsConstructor
@Getter
public enum OrderBillingAddress {
    ENDERECOFATURA_SIMPLES {
        @Override
        public OrderRequestBillingAddress pojo() {
            return OrderRequestBillingAddress.builder()
                    .street("ALEA")
                    .number(700)
                    .detail("Ponto de referência teste")
                    .neighborhood("CENTRO")
                    .city("ELDORADO DO SUL")
                    .region("RS")
                    .country("BR")
                    .postcode("90030140")
                    .build();
        }
    };

    public abstract OrderRequestBillingAddress pojo();
}