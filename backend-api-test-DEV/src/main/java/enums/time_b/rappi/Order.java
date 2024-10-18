package enums.time_b.rappi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.rappi.request.PostOrderRequestV1;

import java.util.Calendar;
import java.util.Collections;

@AllArgsConstructor
@Getter
public enum Order {
    PEDIDO_CLIENTE_CADASTRADO {
        @Override
        public PostOrderRequestV1 pojo() {
            return PostOrderRequestV1.builder()
                    .orderId(Calendar.getInstance().getTimeInMillis())
                    .totalValue(5.0)
                    .retailStoreId(RetailStoreId.RETAIL_STORE_ID.getValue())
                    .orderPreference(OrderPreference.UPDATE_PRODUCTS.getValue())
                    .client(OrderClient.CLIENTE_CADASTRADO.pojo())
                    .delivery(OrderDelivery.ORDER_DELIVERY.pojo())
                    .address(OrderAddress.ENDERECO_LOGRADOURO.pojo())
                    .products(Collections.singletonList(OrderProducts.PRODUTO_SIMPLES.pojo()))
                    .build();
        }
    },
    PEDIDO_CLIENTE_CADASTRADO_CEP_LOCALIDADE {
        @Override
        public PostOrderRequestV1 pojo() {
            return PostOrderRequestV1.builder()
                    .orderId(Calendar.getInstance().getTimeInMillis())
                    .totalValue(5.0)
                    .retailStoreId(RetailStoreId.RETAIL_STORE_ID.getValue())
                    .orderPreference(OrderPreference.UPDATE_PRODUCTS.getValue())
                    .client(OrderClient.CLIENTE_CADASTRADO.pojo())
                    .delivery(OrderDelivery.ORDER_DELIVERY.pojo())
                    .address(OrderAddress.ENDERECO_LOCALIDADE.pojo())
                    .products(Collections.singletonList(OrderProducts.PRODUTO_SIMPLES.pojo()))
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO {
        @Override
        public PostOrderRequestV1 pojo() {
            return PostOrderRequestV1.builder()
                    .orderId(Calendar.getInstance().getTimeInMillis())
                    .totalValue(5.0)
                    .retailStoreId(RetailStoreId.RETAIL_STORE_ID.getValue())
                    .orderPreference(OrderPreference.UPDATE_PRODUCTS.getValue())
                    .client(OrderClient.CLIENTE_NAO_CADASTRADO.pojo())
                    .delivery(OrderDelivery.ORDER_DELIVERY.pojo())
                    .address(OrderAddress.ENDERECO_LOGRADOURO.pojo())
                    .products(Collections.singletonList(OrderProducts.PRODUTO_SIMPLES.pojo()))
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_CEP_LOCALIDADE {
        @Override
        public PostOrderRequestV1 pojo() {
            return PostOrderRequestV1.builder()
                    .orderId(Calendar.getInstance().getTimeInMillis())
                    .totalValue(5.0)
                    .retailStoreId(RetailStoreId.RETAIL_STORE_ID.getValue())
                    .orderPreference(OrderPreference.UPDATE_PRODUCTS.getValue())
                    .client(OrderClient.CLIENTE_NAO_CADASTRADO.pojo())
                    .delivery(OrderDelivery.ORDER_DELIVERY.pojo())
                    .address(OrderAddress.ENDERECO_LOCALIDADE.pojo())
                    .products(Collections.singletonList(OrderProducts.PRODUTO_SIMPLES.pojo()))
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_ENDERECO_SEM_MATCH_FONETICO {
        @Override
        public PostOrderRequestV1 pojo() {
            return PostOrderRequestV1.builder()
                    .orderId(Calendar.getInstance().getTimeInMillis())
                    .totalValue(5.0)
                    .retailStoreId(RetailStoreId.RETAIL_STORE_ID.getValue())
                    .orderPreference(OrderPreference.UPDATE_PRODUCTS.getValue())
                    .client(OrderClient.CLIENTE_NAO_CADASTRADO.pojo())
                    .delivery(OrderDelivery.ORDER_DELIVERY.pojo())
                    .address(OrderAddress.ENDERECO_SEM_MATCH_FONETICO.pojo())
                    .products(Collections.singletonList(OrderProducts.PRODUTO_SIMPLES.pojo()))
                    .build();
        }
    };

    public abstract PostOrderRequestV1 pojo();
}