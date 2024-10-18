package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2 {
    private Integer storeInvoiceId;
    private Integer invoiceId;
    private String observacao;
    private Long numeroCupom;
    private String imprimeDocumentoCupom;
    private Long codigoSituacaoPedido;
    private Long numeroCarrinho;
    private Long codigoFilial;
    private Long idAssinatura;
    private Long codigoFilialCobranca;
    private String tipoPedido;
    private Long usuario;
    private String pedidoUrgente;
    private String imprimeNfe;
    private Integer origemPedido;
    private Integer codOperacao;
    private String pedidoMultiplus;
    private Long codigoLiberadorPedido;
    private BigDecimal valorTotalPedido;
    private PedidosPedidoResponse_v2_RequisicaoCassi requisicaoCassi;
    private PedidosPedidoResponse_v2_Cliente cliente;
    private List<PedidosPedidoResponse_v2_ConvenioUtilizadoDoPedido> convenioUtilizadoPedido;
    private PedidosPedidoResponse_v2_FormaPagamentoDinheiro formaPagamentoDinheiro;
    private PedidosPedidoResponse_v2_FormaPagamentoDevolucao formaPagamentoDevolucao;
    private PedidosPedidoResponse_v2_FormaPagamentoCaixa formaPagamentoCaixa;
    private List<PedidosPedidoResponse_v2_FormaPagamentoCheque> formaPagamentoChequeList;
    private PedidosPedidoResponse_v2_FormaPagamentoBoleto formaPagamentoBoleto;
    private PedidosPedidoResponse_v2_FormaPagamentoConvenio formaPagamentoConvenio;
    private PedidosPedidoResponse_v2_Resgate formaPagamentoResgate;
    private PedidosPedidoResponse_v2_FormaPagamentoDebito formaPagamentoDebito;
    private List<PedidosPedidoResponse_v2_Cartoes> formaPagamentoCartoes;
    private List<PedidosPedidoResponse_v2_FormaPagamentoPbm> formaPagamentoPbm;
    private List<PedidosPedidoResponse_v2_FormaPagamentoEmpresaCartao> formaPagamentoEmpresaCartao;
    private List<PedidosPedidoResponse_v2_FormaPagamentoPrazo> formaPagamentoPrazo;
    private List<PedidosPedidoResponse_v2_FormaPagamentoDebito> formaPagamentoDebitoList;
    private List<PedidosPedidoResponse_v2_FormaPagamentoMarketplace> formaPagamentoMarketplace;
    private PedidosPedidoResponse_v2_Entrega entrega;
    private PedidosPedidoResponse_v2_Endereco enderecoCobranca;
    private PedidosPedidoResponse_v2_Endereco enderecoEntrega;
    private List<PedidosPedidoResponse_v2_Item> itens;
    private String linkNota;
    private Boolean utilizaPanvelGo;
    private Long idLocker;
    private String senhaLocker;
    private Long numeroPortaLocker;
    private String numeroReservaLocker;
    private Boolean podePontuar;
    private String dataEfetiva;
    private String dataHoraEfetiva;
    private PedidosPedidoResponse_v2_Recarga recarga;
    private Long numeroOrcamento;
    private Long codigoOfertaGerada;
    private String cobrancaSeparadaEntrega;
    private String nomeUsuario;
    private Long codigoUsuario;
    private Long codigoFuncionario;
    private Long codigoAloRecurso;
    private Integer idHubMarketplace;
    private Integer idCanalMarketplace;
    private String marketplaceOrderCode;
}