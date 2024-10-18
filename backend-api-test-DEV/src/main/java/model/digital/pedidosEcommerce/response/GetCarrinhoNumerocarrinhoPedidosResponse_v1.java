package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.util.List;

@Data
public class GetCarrinhoNumerocarrinhoPedidosResponse_v1 {
    private List<GetCarrinhoNumerocarrinhoPedidosResponse_v1_Pedidos> pedidos;
}
