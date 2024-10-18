package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_FormaPagamentoConvenio {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private BigInteger numeroCartaoConvenio;
    private List<String> documentosConvenio;
    private String nomeDependente;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private PostPedidosRequest_v2_Doacao doacao;
}
