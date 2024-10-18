package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PutPedidosAtualizarRequest_v2 {
    private BigInteger numeroPedido;
    private BigInteger numeroCupom;
    private String observacao;
    private String imprimeDocumentoCupom;
    private BigInteger codigoSituacaoPedido;
    private BigInteger numeroCarrinho;
    private BigInteger codigoFilial;
    private BigInteger codigoFilialCobranca;
    private String tipoPedido;
    private BigInteger usuario;
    private BigInteger codigoRecurso;
    private String pedidoUrgente;
    private String imprimeNfe;
    private Integer origemPedido;
    private String pedidoMultiplus;
    private BigInteger codigoLiberadorPedido;
    private BigDecimal valorTotalPedido;
    private List<PostPedidosRequest_v2_ConveniosUtilizados> conveniosUtilizados;
    private PostPedidosRequest_v2_RequisicaoCassi requisicaoCassi;
    private PostPedidosRequest_v2_Cliente cliente;
    private PostPedidosRequest_v2_FormaPagamentoDinheiro formaPagamentoDinheiro;
    private PostPedidosRequest_v2_FormaPagamentoCaixa formaPagamentoCaixa;
    private List<PostPedidosRequest_v2_FormaPagamentoChequeList> formaPagamentoChequeList;
    private PostPedidosRequest_v2_FormaPagamentoBoleto formaPagamentoBoleto;
    private PostPedidosRequest_v2_FormaPagamentoConvenio formaPagamentoConvenio;
    private PostPedidosRequest_v2_FormaPagamentoResgate formaPagamentoResgate;
    private PostPedidosRequest_v2_FormaPagamentoDebito formaPagamentoDebito;
    private List<PostPedidosRequest_v2_FormaPagamentoDebito> formaPagamentoDebitoList;
    private List<PostPedidosRequest_v2_FormaPagamentoCartao> formaPagamentoCartoes;
    private List<PostPedidosRequest_v2_PagamentoPbm> formaPagamentoPbm;
    private List<PostPedidosRequest_v2_FormaPagamentoEmpresaCartao> formaPagamentoEmpresaCartao;
    private List<PostPedidosRequest_v2_FormaPagamentoPrazo> formaPagamentoPrazo;
    private PostPedidosRequest_v2_FormaPagamentoDevolucao formaPagamentoDevolucao;
    private PostPedidosRequest_v2_Entrega entrega;
    private PostPedidosRequest_v2_Endereco enderecoCobranca;
    private PostPedidosRequest_v2_Endereco enderecoEntrega;
    private List<PostPedidosRequest_v2_Item> itens;
    private PostPedidosRequest_v2_Recarga recarga;
    private Boolean utilizaPanvelGo;
    private Boolean podePontuar;
    private BigInteger codigoOpercao;
    private BigInteger idAssinatura;
    private BigInteger numeroOrcamento;
    private BigInteger codigoOfertaGerada;
    private String metodoCapturaCartao;
}
