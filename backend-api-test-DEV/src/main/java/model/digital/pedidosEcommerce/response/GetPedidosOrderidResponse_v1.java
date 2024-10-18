package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1 {
    private String observacao;
    private String descricaoSituacaoPedido;
    private BigInteger numeroCupom;
    private String imprimeDocumentoCupom;
    private BigInteger codigoSituacaoPedido;
    private BigInteger numeroCarrinho;
    private BigInteger codigoFilial;
    private BigInteger idAssinatura;
    private BigInteger codigoFilialCobranca;
    private String tipoPedido;
    private BigInteger usuario;
    private String pedidoUrgente;
    private String imprimeNfe;
    private Integer origemPedido;
    private Integer codOperacao;
    private String pedidoMultiplus;
    private BigInteger codigoLiberadorPedido;
    private BigDecimal valorTotalPedido;
    private GetPedidosOrderidResponse_v1_Chassi requisicaoCassi;
    private GetPedidosOrderidResponse_v1_Cliente cliente;
    private List<GetPedidosOrderidResponse_v1_ConvenioUtilizadoPedido> convenioUtilizadoPedido;
    private GetPedidosOrderidResponse_v1_FormaPagamentoDinheiro formaPagamentoDinheiro;
    private GetPedidosOrderidResponse_v1_FormaPagamentoDevolucao formaPagamentoDevolucaoModel;
    private GetPedidosOrderidResponse_v1_FormaPagamentoCaixa formaPagamentoCaixa;
    private List<GetPedidosOrderidResponse_v1_FormaPagamentoCheque> formaPagamentoChequeList;
    private GetPedidosOrderidResponse_v1_FormaPagamentoBoleto formaPagamentoBoleto;
    private GetPedidosOrderidResponse_v1_FormaPagamentoConvenio formaPagamentoConvenio;
    private GetPedidosOrderidResponse_v1_FormaPagamentoResgate formaPagamentoResgate;
    private GetPedidosOrderidResponse_v1_FormaPagamentoDebito formaPagamentoDebito;
    private List<GetPedidosOrderidResponse_v1_FormaPagamentoCartao> formaPagamentoCartoes;
    private List<GetPedidosOrderidResponse_v1_FormaPagamentoPbm> formaPagamentoPbm;
    private List<GetPedidosOrderidResponse_v1_FormaPagamentoCartaoEmpresarial> formaPagamentoEmpresaCartaoModel;
    private List<GetPedidosOrderidResponse_v1_FormaPagamentoPrazo> formaPagamentoPrazoModel;
    private List<GetPedidosOrderidResponse_v1_FormaPagamentoDebito> formaPagamentoDebitoList;
    private GetPedidosOrderidResponse_v1_Entrega entrega;
    private GetPedidosOrderidResponse_v1_Endereco enderecoCobranca;
    private GetPedidosOrderidResponse_v1_Endereco enderecoEntrega;
    private List<GetPedidosOrderidResponse_v1_Item> itens;
    private String linkNota;
    private Boolean utilizaPanvelGo;
    private BigInteger idLocker;
    private String senhaLocker;
    private BigInteger numeroPortaLocker;
    private String numeroReservaLocker;
    private Boolean podePontuar;
    private GetPedidosOrderidResponse_v1_Recarga recargaModel;
    private BigInteger numeroOrcamento;
    private String dataEfetiva;
    private BigInteger codigoOfertaGerada;
    private String cobrancaSeparadaEntrega;
    private BigInteger orderId;
    private Integer status;
    private String situacao;
    private String dataHoraEfetiva;
}
