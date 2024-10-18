package enums.digital.pedidoEcommerce;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.digital.pedidosEcommerce.request.PostPedidoRequest_v1;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum PedidoGenerate {
    PEDIDO_SIMPLES {
        @Override
        public PostPedidoRequest_v1 pojo() {
            return PostPedidoRequest_v1.builder()
                    .tipoPedido("I")
                    .origemPedido(1)
                    .codigoFilial(480L)
                    .codigoSituacaoPedido(17L)
                    .valorTotalPedido(new BigDecimal("3.15"))
                    .imprimeDocumentoCupom("S")
                    .pedidoUrgente("N")
                    .cliente(null) //TODO: Passar parametro
                    .entrega(null) //TODO: Enriquecer
                    .enderecoEntrega(null) //TODO: Enriquecer
                    .itens(null) //TODO: Preencher
                    .formaPagamentoCartoes(null) //TODO: Enriquecer
                    .numeroCarrinho(null)  //TODO: Enriquecer
                    .build();
        }
    },
    PEDIDO_COMPLETO {
        @Override
        public PostPedidoRequest_v1 pojo() {
            return PostPedidoRequest_v1.builder()
                    .cliente(null)
                    .build();
        }
    };

    public abstract PostPedidoRequest_v1 pojo();
}
