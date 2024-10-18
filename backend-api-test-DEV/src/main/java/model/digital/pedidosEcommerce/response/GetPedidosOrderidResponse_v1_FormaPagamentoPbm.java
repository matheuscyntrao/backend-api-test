package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_FormaPagamentoPbm {
   private BigInteger codigoFormaPagamento;
   private String tipoPagamento;
   private BigDecimal valor;
   private Integer sequenciaFormaPagamento;
   private BigInteger nsuTransacao;
   private BigInteger codigoFilialConvenio;
   private BigInteger codigoConvenio;
   private Integer confCodigoCondicaoPagamento;
   private Integer confSequenciaCondicao;
   private String numeroAutorizacao;
   private Integer situacao;
}
