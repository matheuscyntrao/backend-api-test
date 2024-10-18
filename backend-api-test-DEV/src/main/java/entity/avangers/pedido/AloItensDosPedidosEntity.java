package entity.avangers.pedido;

import lombok.Data;

@Data
public class AloItensDosPedidosEntity {
    private Integer numeroDoItem;
    private Integer codigoDoItem;
    private Integer quantidade;
    private Double valorUnitario;
    private Double valorTotalDoItem;
    private Double valorDoDesconto;
    private Integer origemDoDesconto;
}