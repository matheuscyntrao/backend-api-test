package model.avengers.pedido.response;

import lombok.Data;

@Data
public class PedidosPedidoResponse_v2_FormaPagamentoMarketplace {
    private Integer codigoConvenio;
    private Integer codigoFilialConvenio;
    private Integer codigoFormaPagamento;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private Integer sequenciaFormaPagamento;
    private Double valor;
}