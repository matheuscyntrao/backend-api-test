package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidosFormaPagamentoUraAtualizarRequest_v2 {
    private BigInteger numeroPedido;
    private BigInteger cartaoId;
    private BigInteger codCliente;
    private String salvarCartao;
    private PostPedidosFormaPagamentoUraAtualizarRequest_v2_Cartao cartao;
}
