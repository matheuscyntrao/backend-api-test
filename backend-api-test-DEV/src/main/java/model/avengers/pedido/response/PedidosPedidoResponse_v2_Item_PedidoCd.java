package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2_Item_PedidoCd {
    private BigInteger numeroPedidoCD;
    private BigInteger codigoFilialCD;
    private Integer statusPedidoCD;
}
