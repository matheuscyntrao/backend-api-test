package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidosPedidoResponse_v2_Item_Desconto {
    private BigDecimal valorDesconto;
    private String tipoDesconto;
    private Double percentualDesconto;
    private Integer origemDesconto;
    private PedidosPedidoResponse_v2_Item_Desconto_DescontoAVista convenioAvista;
}
