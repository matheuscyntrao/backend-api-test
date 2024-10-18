package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item_PedidoCd {
    private BigInteger codigoFilialCD;
    private BigInteger numeroPedidoCD;
}
