package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2_FormaPagamentoBoleto {
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private String dataVencimento;
    private String numeroBoleto;
    private BigInteger codigoFilialMatriz;
    private BigInteger codigoEntidadeComercial1;
    private BigInteger codigoEntidadeComercial2;
    private BigInteger codigoTipoPapelNegocio;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
