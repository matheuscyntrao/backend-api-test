package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidosFormaPagamentoUraAtualizarRequest_v2_Cartao {
    private String codigoSeguranca;
    private String numeroCartao;
    private String dataExpiracaoCartao;
    private String cartaoPrincipal;
}
