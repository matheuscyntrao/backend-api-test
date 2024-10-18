package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_FormaPagamentoBoleto {
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private String dataVencimento;
    private String numeroBoleto;
    private BigInteger codigoFilialMatriz;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
