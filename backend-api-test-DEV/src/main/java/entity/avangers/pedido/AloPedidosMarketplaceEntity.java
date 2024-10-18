package entity.avangers.pedido;

import lombok.Data;

@Data
public class AloPedidosMarketplaceEntity {
    private Integer codigoDaSituacaoPedido;
    private Integer origemPedido;
    private String tipoDePedido;
    private Integer idHubMarketplace;
    private Integer idCanalMarketplace;
    private String marketplaceOrderCode;
    private String observacao;
}