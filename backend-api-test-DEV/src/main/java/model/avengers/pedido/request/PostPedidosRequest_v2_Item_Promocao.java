package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Item_Promocao {
    private BigInteger codigoFilialPromotora;
    private BigInteger codigoPromocao;
}
