package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_FormaPagamentoResgate {
    private String numeroCartao;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private BigInteger cartaoIin;
    private BigInteger cartao;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private Integer sequenciaFormaPagamento;
    private PostPedidosRequest_v2_Doacao doacao;
}
