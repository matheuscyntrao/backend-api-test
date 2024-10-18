package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_Item_Promocao {
    private BigInteger codigoFilialPromotora;
    private BigInteger codigoPromocao;
}
