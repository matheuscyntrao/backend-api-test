package model.avengers.pedido.response;

import lombok.Builder;
import lombok.Data;
import model.avengers.pedido.response.orm.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class GetPedidosRetirada_v2 {

   private Integer numeroPedido;
   private Cliente cliente;
   private LocalDateTime dataPedido;
   private BigDecimal valorTotalPedido;

}
