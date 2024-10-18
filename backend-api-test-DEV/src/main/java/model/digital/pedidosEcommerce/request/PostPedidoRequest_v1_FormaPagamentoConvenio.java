package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_FormaPagamentoConvenio {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private BigInteger numeroCartaoConvenio;
    private List<PostPedidoRequest_v1_FormaPagamentoConvenio_DocumentosConvenio> documentosConvenio;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
