package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetCarrinhoNumerocarrinhoPedidosResponse_v1_Pedidos {
    private BigInteger numeroPedido;
    private Integer statusPedido;
}
