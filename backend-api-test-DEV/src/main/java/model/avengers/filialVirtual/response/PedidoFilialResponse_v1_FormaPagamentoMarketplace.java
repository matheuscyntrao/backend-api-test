package model.avengers.filialVirtual.response;

import lombok.Data;

@Data
public class PedidoFilialResponse_v1_FormaPagamentoMarketplace {
    private Integer codigoConvenio;
    private Integer codigoFilialConvenio;
    private Integer codigoFormaPagamento;
    private Integer confCodigoCondicaoPagamento;
    private Integer confSequenciaCondicao;
    private Integer sequenciaFormaPagamento;
    private Double valor;
}
