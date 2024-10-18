package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_PagamentoPbm {
    private BigInteger nsuTransacao;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private String numeroAutorizacao;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private PostPedidosRequest_v2_Doacao doacao;
}
