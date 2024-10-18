package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoAvaliacaoResponse_v2 {
    private BigInteger idAvaliacao;
    private BigInteger pedido;
    private Integer avaliacao;
    private String comentario;
    private String dataAvaliacao;
}
