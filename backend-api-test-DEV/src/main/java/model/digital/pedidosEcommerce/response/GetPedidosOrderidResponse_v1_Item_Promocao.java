package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Item_Promocao {
    private BigInteger codigoFilialPromotora;
    private BigInteger codigoPromocao;
}
