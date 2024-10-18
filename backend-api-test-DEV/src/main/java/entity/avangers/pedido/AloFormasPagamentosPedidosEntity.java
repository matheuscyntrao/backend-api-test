package entity.avangers.pedido;

import lombok.Data;

@Data
public class AloFormasPagamentosPedidosEntity {
    private Integer codigoDaFormaDePagamento;
    private Integer codigoDaFilialDoConvenio;
    private Integer codigoDoConvenio;
    private Integer sequenciaFormaPagtoPedido;
}