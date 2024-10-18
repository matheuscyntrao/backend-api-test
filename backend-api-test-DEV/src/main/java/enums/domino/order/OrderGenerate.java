package enums.domino.order;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.digital.pedidosEcommerce.request.PostPedidoRequest_v1;
import model.domino.order.PostOrderEcommerceOrdersRequest_v1;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum OrderGenerate {
    PEDIDO_SIMPLES {
        @Override
        public PostOrderEcommerceOrdersRequest_v1 pojo() {
            return PostOrderEcommerceOrdersRequest_v1.builder()
                    .build();
        }
    },
    PEDIDO_COMPLETO {
        @Override
        public PostOrderEcommerceOrdersRequest_v1 pojo() {
            return PostOrderEcommerceOrdersRequest_v1.builder()
                    .build();
        }
    };

    public abstract PostOrderEcommerceOrdersRequest_v1 pojo();
}
