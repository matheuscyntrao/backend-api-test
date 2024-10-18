package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosCpfPendentesResponse_v2 {
    private BigInteger numeroPedido;
    private BigInteger codigoSituacaoPedido;
    private String descricaoSituacaoPedido;
    private String descricaoFormaEntrega;
    private String descricaoQualificacaoFormaEntrega;
    private String dataEntrega;
    private Boolean pedidoMonitorado;
    private BigInteger filial;
    private BigDecimal valorTotal;
    private String dataCriacao;
}
