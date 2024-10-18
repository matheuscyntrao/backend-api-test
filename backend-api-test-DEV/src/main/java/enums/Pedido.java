package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.avengers.pedido.request.PostPedidosRetirada_v2;
import model.avengers.pedido.response.GetPedidosRetirada_v2;
import model.digital.pedidosEcommerce.request.PostPedidoRequest_v1;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@AllArgsConstructor
public enum Pedido {

    PEDIDO_RETIRADA_BALCAO {
        @Override
        public PostPedidoRequest_v1 pojo() {
            return PostPedidoRequest_v1.builder()
                    //.codigoSituacaoPedido(BigInteger.valueOf(35))
                    //.codigoFilial(BigInteger.valueOf(101))
                    .numeroCarrinho(null) // Incrementar pelo post do carrinho
                    .podePontuar(true)
                    .tipoPedido(TipoPedido.INTERNET.getTipoPedido())
                    .origemPedido(6)
                    .pedidoUrgente("S")
                    .valorTotalPedido(BigDecimal.valueOf(91.86))
                    .cliente(null)
                    .enderecoEntrega(null)
                    .entrega(null)
                    .conveniosUtilizados(null)
                    .itens(null)
                    .formaPagamentoDinheiro(null)
                    .build();
        }
    },
    PEDIDO_RETIRADA_ENTREGA_EM_CASA_EXPRESS {
        @Override
        public PostPedidoRequest_v1 pojo() {
            return PostPedidoRequest_v1.builder()
                    //.numeroPedido(null)
                    .itens(null)
                    .cliente(null)
                    //.codgoOfertaGerada(null)
                    .enderecoEntrega(null)
                    .entrega(null)
                    .tipoPedido(TipoPedido.FILIAL.getTipoPedido())
                    .pedidoUrgente("N")
                    .podePontuar(true)
                    .valorTotalPedido(BigDecimal.valueOf(52.83))
                    //.codigoSituacaoPedido(BigInteger.valueOf(5))
                    .imprimeNfe("N")
                    .conveniosUtilizados(null)
                    //.codigoFilial(BigInteger.valueOf(31))
                    //.codigoFilialCobranca(BigInteger.valueOf(101))
                    .utilizaPanvelGo(true)
                    //.recarga(null)
                    .enderecoCobranca(null)
                    .formaPagamentoDinheiro(null)
                    .formaPagamentoCartoes(null)
                    .formaPagamentoDebito(null) //"formaPagamentoDebitoList": [],
                    .formaPagamentoCheque(null) //"formaPagamentoChequeList": [],
                    .formaPagamentoConvenio(null) //"formaPagamentoEmpresaCartao": [],
                    //.formaPagamentoPrazo "formaPagamentoPrazo": [],
                    //.codigoOperacao(826)
                    //.usuario(3700)
                    //.codigoRecurso(BigInteger.valueOf(78610))
                    //.numeroCarrinho(BigInteger.valueOf(162526))
                    .build();
        }
    },
    PEDIDO_RETIRADA_ENTREGA_EM_CASA_PROGRAMADA {
        @Override
        public PostPedidoRequest_v1 pojo() {
            return PostPedidoRequest_v1.builder()
                //.numeroPedido(null)
                .itens(null)
                .cliente(null)
                //.codigoOfertaGerada(null)
                .enderecoEntrega(null)
                .entrega(null)
                .tipoPedido(TipoPedido.FILIAL.getTipoPedido())
                .pedidoUrgente("N")
                .podePontuar(true)
                .valorTotalPedido(BigDecimal.valueOf(117.67))
                //.codigoSituacaoPedido(BigInteger.valueOf(5))
                .imprimeNfe("N")
                .conveniosUtilizados(null)
                //.codigoFilial(BigInteger.valueOf(711))
                //.codigoFilialCobranca(BigInteger.valueOf(101))
                .utilizaPanvelGo(false)
                //.recarga(null)
                .enderecoCobranca(null)
                .formaPagamentoDinheiro(null)
                .formaPagamentoCartoes(null)
                //.formaPagamentDebitoList(null)
                //.formaPagamentoChequeList(null)
                .formaPagamentoConvenio(null) //"formaPagamentoEmpresaCartao": [],
                //.formaPagamentoPrazo "formaPagamentoPrazo": [],
                //.codigoOperacao(826)
                //.usuario(3700)
                //.codigoRecurso(BigInteger.valueOf(78610))
                    //.numeroCupom(162527);
                    .build();

            }

    },
    PEDIDO_RETIRADA_EM_OUTRA_LOJA {
        @Override
        public PostPedidoRequest_v1 pojo() {
            return PostPedidoRequest_v1.builder()
                //.numeroPedido(null)
                .itens(null)
                .cliente(null)
                //.codigoOfertaGerada(null)
                .enderecoEntrega(null)
                .entrega(null)
                .tipoPedido("F")
                .pedidoUrgente("N")
                .podePontuar(true)
                .valorTotalPedido(BigDecimal.valueOf(42.4))
                //.codigoSituacaoPedido(BigInteger.valueOf(5))
                .imprimeNfe("N")
                .conveniosUtilizados(null)
                //.codigoFilialCobranca(BigInteger.valueOf(101))
                .utilizaPanvelGo(false)
                //.recarga(null)
                .enderecoCobranca(null)
                .formaPagamentoDinheiro(null)
                .formaPagamentoCartoes(null)
                .formaPagamentoDebito(null) // "formaPagamentoDebitoList": [],
                .formaPagamentoCheque(null) // "formaPagamentoChequeList": [],
                .formaPagamentoConvenio(null) // "formaPagamentoEmpresaCartao": [],
                //.formaPagamentoPrazo(null)
                //.codigoOperacao(826)
                //.usuario(3700)
                //.codigoRecurso(BigInteger.valueOf(78610))
                //.numeroCupom(162528)
                .build();
        }
    };

    public abstract PostPedidoRequest_v1 pojo();
}
