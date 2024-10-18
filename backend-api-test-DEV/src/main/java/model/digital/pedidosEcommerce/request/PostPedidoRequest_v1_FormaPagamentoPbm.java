package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_FormaPagamentoPbm {
    private BigInteger nsuTransacao;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private String numeroAutorizacao;
    private Integer situacao;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
