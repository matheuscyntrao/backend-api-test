package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_Item_PedidoCd {
    private BigInteger numeroPedidoCD;
    private BigInteger codigoFilialCD;
    private Integer statusPedidoCD;
}
