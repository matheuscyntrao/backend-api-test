package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_FormaPagamentoResgate {
    private String numeroCartao;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private BigInteger cartaoIin;
    private BigInteger cartao;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
}
