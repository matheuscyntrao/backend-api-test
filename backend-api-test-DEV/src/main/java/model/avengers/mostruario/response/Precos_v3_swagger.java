package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Precos_v3_swagger {
    private Integer codItem;
    private Integer codTipoItem;
    private Integer codFilial;
    private Boolean vendaLiberada;
    private String nomenclatura;
    private BigDecimal precoDe;
    private BigDecimal precoPor;
    private BigDecimal percentualDesconto;
    private Integer codPromocao;
    private Boolean psicotropico;
    private Boolean retencaoReceita;
    private Boolean possuiGenericos;
    private Integer itensAlternativos[];
    private String advertencias[];
    private String bula;
    private Boolean farmaciaPopular;
    private BigDecimal precoFidelidade;
    private Boolean multiAtendimento;
    private PrecosResponse_v3_DadosImagem dadosImagens[];
    private PrecosResponse_v3_Categoria categorias[];
    private PrecosResponse_v3_DadosPack dadosPack;
    private Boolean isPack;
    private String linksVideo[];
    private Integer restricoes[];
}
