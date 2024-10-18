package model.domino.filial.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFiliaisConsultaResponse_v1 {
    private Long filial;
    private String nome;
    private Long cgc;
    private PostFiliaisConsultaResponse_v1_Endereco endereco;
    private PostFiliaisConsultaResponse_v1_Horarios horarios;
    private PostFiliaisConsultaResponse_v1_Entregas entregas;
    private Boolean pendenciaPedido;
    private Boolean estoqueNegativo;
    private Boolean cancelamentoContinuoItem;
    private Integer intervaloRotatividade;
    private String dataUltimaMediaVenda;
    private String nominalParaCheques;
    private Long codReduzido;
    private Long codContabil;
    private Integer maxDiaCheque;
    private Boolean requeridoCanhoto;
    private Long codDimed;
    private Integer cadeiaMininaPesquisa;
    private String mensagemCupomFiscal;
    private Long codDistribuidorDimed;
    private Boolean fechamento;
    private Integer tempoMaximoSaidaPedido;
    private String dataUltimaAbertura;
    private String dataUltimoFechamento;
    private BigDecimal valorMinimoCheque;
    private BigDecimal maximoDescontoNota;
    private Boolean filialBalcao;
    private Integer seqAcertosDimed;
    private String caminhoArquivos;
    private String dataUltimaExportacao;
    private String dataUltimaBuscaPreco;
    private Long codDistribuidorPanvel;
    private Integer numeroPeriodos;
    private String dataUltimaRentabilidade;
    private Boolean filialEpharma;
    private Boolean filialGoodmed;
    private Boolean solicitaVendedor;
    private BigDecimal jurosMora;
    private BigDecimal multaAtraso;
    private Integer diasMulta;
    private Long codCondicaoPagamento;
    private Long codInstrucaoJuros;
    private Long codInstrucaoMulta;
    private Boolean bancoFilialParado;
    private Integer maximoDiasDebitoPre;
    private Long codUsuarioConfRedifi;
    private Long codFeriadoVendaPrazo;
    private Boolean inventarioAberto;
    private String nomeAmigavel;
    private Boolean novoLoad;
    private Long cnpjMatriz;
    private Long telefone;
    private Long celular;
    private Boolean confPreVendaOmni;
    private Boolean confVendaOmni;
    private Boolean checkoutOmni;
    private Boolean gravaVendaNaoEfetivada;
    private BigDecimal valorMinimoPedido;
    private BigDecimal valorMinimoPedidoInternet;
    private Long codFilialContingencia;
    private Long codFilialCentralizadora;
    private Integer funcionamentoFinaisSemana;
    private Boolean indicadorFeriado;
    private Integer diaSemana;
    private Integer prazoInternoPadrao;
    private BigDecimal vlrMaximoChequeSemLib;
    private PostFiliaisConsultaResponse_v1_Servicos servicos;
    private Boolean filialAberta;
}
