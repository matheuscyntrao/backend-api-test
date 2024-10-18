package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_FormaPagamentoDebito {
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger nsuTransacao;
    private String numeroCartao;
}
