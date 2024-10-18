package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_FormaPagamentoDebito {
    private Long codigoFilialConvenio;
    private Long codigoConvenio;
    private Long codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private Long idCartao;
    private Integer installmentType;
    private Integer installments;
}
