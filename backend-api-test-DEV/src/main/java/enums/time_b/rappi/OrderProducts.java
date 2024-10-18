package enums.time_b.rappi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.rappi.request.PostOrderRequestV1Products;

@AllArgsConstructor
@Getter
public enum OrderProducts {
    PRODUTO_SIMPLES {
        @Override
        public PostOrderRequestV1Products pojo() {
            return PostOrderRequestV1Products.builder()
                    .id("402732")
                    .retailId("402732")
                    .quantity(1)
                    .units(1)
                    .unitsType("UN")
                    .value(5.00)
                    .build();
        }
    };

    public abstract PostOrderRequestV1Products pojo();
}