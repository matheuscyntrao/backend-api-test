package model.avengers.pedido.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostPedidosRetirada_v2 {
    private Integer matriculaOperador;
    public Integer numerosPedidos;
}
