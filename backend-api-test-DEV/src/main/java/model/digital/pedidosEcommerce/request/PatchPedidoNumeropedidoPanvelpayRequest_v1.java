package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PatchPedidoNumeropedidoPanvelpayRequest_v1 {
    private BigInteger idCartao;
    private BigInteger codigoFormaPagamento;
    private BigInteger codigoConvenio;
    private String cvv;
    private BigDecimal valorTotal;
    private Integer codigoCondicaoPagamento;
    private Integer parcelas;
    private String tipoPagamento;
}
