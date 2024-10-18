package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_FormaPagamentoBoleto {
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private String dataVencimento;
    private String numeroBoleto;
    private BigInteger codigoFilialMatriz;
    private BigInteger codigoEntidadeComercial1;
    private BigInteger codigoEntidadeComercial2;
    private BigInteger codigoTipoPapelNegocio;
}
