package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_Item_PedidoPcd {
    private BigInteger codigoFilialCD;
    private BigInteger numeroPedidoCD;
}
