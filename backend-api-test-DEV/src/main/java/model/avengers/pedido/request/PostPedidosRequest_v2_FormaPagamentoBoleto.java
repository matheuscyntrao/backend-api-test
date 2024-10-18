package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_FormaPagamentoBoleto {
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private BigInteger codigoFilialMatriz;
    private String dataVencimento;
    private String numeroBoleto;
    private BigInteger codigoEntidadeComercial1;
    private BigInteger codigoEntidadeComercial2;
    private Integer codigoTipoPapelNegocio;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private PostPedidosRequest_v2_Doacao doacao;
}
