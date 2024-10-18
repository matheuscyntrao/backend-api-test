package model.avengers.mostruario.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ItensDetalheResponseV3Item {
    private Boolean pbmZiCard;
    private Boolean permiteTokenReceita;
    private Integer codigo;
    private Integer codigoFilial;
    private BigDecimal precoDe;
    private BigDecimal precoPor;
    private Integer quantidade;
    private String origemDesconto;
    private Double percentualDesconto;
    private String descricaoDetalhadaItem;
    private Integer codigoFabricante;
    private BigInteger ean;
    private BigInteger eansAlternativos[];
    //TODO: Verificar response com categorias
    private String categoria;
    private ItensDetalheResponseV3ItemCategoria categorias[];
    private Boolean participaPack;
    private Boolean participaPackNovo;
    private ItensDetalheResponseV3ItemNovoPack novoPack;
    private Boolean participaPbm;
    private ItensDetalheResponseV3ItemPromocao promocao;
    private ItensDetalheResponseV3ItemRegraFiscal regraFiscal;
    private ItensDetalheResponseV3ItemConvenio convenio;
    private Integer qtdApresentacao;
    private Integer qtdApresentacaoUnitaria;
    private Integer codigoPrincipioAtivo;
    private String principioAtivo;
    private String classeTerapeutica;
    private Integer codigoTipoDoItem;
    private Boolean vendaLiberada;
    private Boolean psicotropico;
    private Boolean retencaoReceita;
    private Boolean possuiGenericos;
    private Boolean lancamento;
    private Boolean possuiSimilares;
    private Boolean possuiAlternativos;
    private Boolean possuiSimilaresPorPrincipioAtivo;
    private Boolean possuiGenericosPorPrincipioAtivo;
    private Boolean possuiReferenciaPorPrincipioAtivo;
    private Boolean possuiItemAVencer;
    private Boolean bloqueadoInternet;
    private Boolean presenteavel;
    private Boolean permiteAdesao;
    private Boolean possuiKitAdesao;
    private Boolean exclusivoPanvel;
    private Boolean participaListaReferencial;
    private Boolean participaFarmaciaPopular;
    private Boolean promocaoAssinatura;
    private Boolean itemGeladeira;
    private Boolean possuiEanImpresso;
    private Boolean usoContinuo;
    private Boolean farmaciaPopular;
    private Boolean multiAtendimento;
    private Boolean geraDadosFornecedor;
    private Boolean itemAssinavel;
    private String situacaoItem;
    //TODO:Verificar se é isso
    private String advertencias[];
    private String bula;
    private String nomenclatura;
    private String nomenclaturaDetalhada;
    private ItensDetalheResponseV3ItemDadosImagem dadosImagens[];
    //TODO:Verificar response
    private String linksVideo[];
    //TODO:Verificar response
    private String restricoes[];
    private String indicadorOtc;
    private Integer codigoMarcaPai;
    private String descricaoMarcaPai;
    private BigDecimal rentabilidadeReposicao;
    private Double rankingItem;
    private String reposicao;
    private String dataPrimeiraEntrada;
    private String dataUltimaVenda;
    private String dataUltTransRecebidaDimed;
    private BigDecimal custoMedio;
    private BigDecimal precoBaseZero;
    private Double percentualMargemBruta;
    private Double percentualMargemLiquida;
    private Double fatorMargem;
    private BigDecimal custoReposicao;
    private ItensDetalheResponseV3ItemDesconto descontos[];
}
