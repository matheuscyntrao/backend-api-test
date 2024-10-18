package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_FormaPagamentoCartoes {
    private String numeroCartao;
    private String cvv;
    private String dataValidade;
    private String nsuTransacao;
    private String numeroAutorizacao;
    private Long codigoFilialConvenio;
    private Long codigoConvenio;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private Long idCartao;
    private String cardHash;
    private String titular;
    private Integer authorizerId;
    private Integer installmentType;
    private Integer installments;
    private Long codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
