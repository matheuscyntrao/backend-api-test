package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2_FormaPagamentoDevolucao {
    private BigDecimal valorTroco;
    private BigInteger sequenciaCredDevolucao;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
