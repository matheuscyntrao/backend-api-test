package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_Entrega {
   private Integer codigoFormaEntrega;
   private Integer codigoTipoEntrega;
   private BigInteger codigoRota;
   private String dataHoraEntrega;
   private String dataHoraSaidaRota;
   private String cpfRetiradaBalcao;
   private BigInteger codigoTaxa;
   private String tipoTaxa;
   private BigDecimal valorTaxa;
   private BigInteger codigoLiberadorTaxa;
   private String convenioPagaTaxa;
   private String origemDesvioEstoque;
   private Integer numeroItem;
}
