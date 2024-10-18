package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_FormaPagamentoCartao {
    private String numeroCartao;
    private String numeroAutorizacaoCartao;
    private String dataValidade;
    private String nsuTransacao;
    private String numeroAutorizacao;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private BigInteger idCartao;
    private String nitTransacaoEsitef;
    private String titular;
    private String dataVencimento;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private PostPedidosRequest_v2_Doacao doacao;
}
