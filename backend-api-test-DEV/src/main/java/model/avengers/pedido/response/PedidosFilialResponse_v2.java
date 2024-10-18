package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosFilialResponse_v2 {
    private Integer filial;
    private BigInteger numeroPedido;
    private Integer origemPedido;
    private String nomeCliente;
    private String tipoPedido;
    private String dataPedido;
    private Integer codigoSituacaoPedido;
    private String descricaoSituacaoPedido;
    private BigDecimal valorTotal;
    private BigInteger codigoCliente;
    private String dataHoraStatus;
    private String tipoEntrega;
}
