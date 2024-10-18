package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2_Cartoes {
    private Integer parcelas;
    private String numeroCartao;
    private String numeroAutorizacaoCartao;
    private String dataValidade;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private BigInteger idCartao;
    private String nitTransacao;
    private String titular;
    private BigInteger nsuTransacao;
    private String numeroAutorizacao;
    private String dataVencimento;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
