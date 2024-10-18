package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ItensSimilaresResponse_v3_Item {
    private Integer codigo;
    private Integer codigoFilial;
    private BigDecimal precoDe;
    private BigDecimal precoPor;
    private Integer quantidade;
    private String origemDesconto;
    private Integer percentualDesconto;
    private BigInteger codigoFabricante;
    private BigInteger ean;
    private String categoria;
    private ItensSimilaresResponse_v3_Item_Categorias categorias[];
    private Boolean participaPack;
    private Boolean participaPackNovo;
    private Boolean participaPbm;
    private ItensSimilaresResponse_v3_Item_Promocao promocao;
    private Integer qtdApresentacaoUnitaria;
    private Integer codigoPrincipioAtivo;
    private String principioAtivo;
    private String classeTerapeutica;
    private Integer codigoTipoDoItem;
    private Boolean vendaLiberada;
    private Boolean psicotropico;
    private Boolean retencaoReceita;
    private Boolean possuiGenericos;
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
    private Boolean usoContinuo;
    private Boolean farmaciaPopular;
    private Boolean multiAtendimento;
    private Boolean geraDadosFornecedor;
    private Boolean itemAssinavel;
    private String situacaoItem;
    private String nomenclatura;
    private String nomenclaturaDetalhada;
    private String dadosImagens[];
    private Integer restricoes[];
    private String indicadorOtc;
    private Integer codigoMarcaPai;
    private String descricaoMarcaPai;
    private BigDecimal precoBaseZero;
    private Double percentualMargemBruta;
    private Double percentualMargemLiquida;
    private Double fatorMargem;
    private BigDecimal custoReposicao;

}
