package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidosPedido_v2_Item {
    private Integer codigoItem;
    private Integer numeroItem;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private Double percentualIsencao;
    private String preVenda;
    private Integer quantidadeEmEstoque;
    private PedidosPedidoResponse_v2_Item_Desconto desconto;
    private PedidosPedidoResponse_v2_Item_RequisicaoCassi requisicaoCassi;
    private Boolean itemDigitado;
}
