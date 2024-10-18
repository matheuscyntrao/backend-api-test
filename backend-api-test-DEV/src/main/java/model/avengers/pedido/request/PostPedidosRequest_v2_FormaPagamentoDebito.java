package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_FormaPagamentoDebito {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private String numeroCartao;
    private String nsuTransacao;
    private String numeroAutorizacao;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private PostPedidosRequest_v2_Doacao doacao;
}