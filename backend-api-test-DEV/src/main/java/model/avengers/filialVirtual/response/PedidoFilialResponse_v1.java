package model.avengers.filialVirtual.response;

import lombok.Data;
import model.avengers.pedido.response.PedidosPedidoResponse_v2_FormaPagamentoMarketplace;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PedidoFilialResponse_v1 {
    private String imprimeDocumentoCupom;
    private Integer codigoSituacaoPedido;
    private Integer codigoFilial;
    private Integer codigoFilialCobranca;
    private String tipoPedido;
    private String pedidoUrgente;
    private String imprimeNfe;
    private Integer origemPedido;
    private Integer codOperacao;
    private BigDecimal valorTotalPedido;
    private PedidoFilialResponse_v1_Cliente cliente;
    private PedidoFilialResponse_v1_ConvenioUtilizadoPedido convenioUtilizadoPedido[];
    private Object formaPagamentoChequeList[];
    private List<PedidoFilialResponse_v1_FormaPagamentoMarketplace> formaPagamentoMarketplace;
    private PedidoFilialResponse_v1_Entrega entrega;
    private PedidoFilialResponse_v1_EnderecoEntrega enderecoEntrega;
    private PedidoFilialResponse_v1_Item itens[];
    private String linkNota;
    private Boolean utilizaPanvelGo;
    private Boolean podePontuar;
    private Boolean contingencia;
    private String dataEfetiva;
    private String cobrancaSeparadaEntrega;
    private Integer idHubMarketplace;
    private Integer idCanalMarketplace;
    private String marketplaceOrderCode;
}
