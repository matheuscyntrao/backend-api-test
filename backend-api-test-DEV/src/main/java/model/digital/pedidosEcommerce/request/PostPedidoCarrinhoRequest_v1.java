package model.digital.pedidosEcommerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostPedidoCarrinhoRequest_v1 {
    private Long codigoEntidadeComercial;
}
