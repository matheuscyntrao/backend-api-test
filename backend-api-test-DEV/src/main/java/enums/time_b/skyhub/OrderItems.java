package enums.time_b.skyhub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.skyhub.request.OrderRequestItems;

@AllArgsConstructor
@Getter
public enum OrderItems {
    ITENS_SIMPLES {
        @Override
        public OrderRequestItems pojo() {
            return OrderRequestItems.builder()
                    .id("119681")
                    .qty(1)
                    .originalPrice(25.00)
                    .specialPrice(25.00)
                    .build();
        }
    },
    ITEM_COM_DESCONTO {
        @Override
        public OrderRequestItems pojo() {
            return OrderRequestItems.builder()
                    .id("119436")
                    .qty(1)
                    .originalPrice(119.99)
                    .specialPrice(101.99)
                    .build();
        }
    };

    public abstract OrderRequestItems pojo();
}