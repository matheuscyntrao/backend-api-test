package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItensDetalheResponseV3ItemDesconto {
    private String origemDesconto;
    private Integer codigo;
    private Integer tipoDesconto;
    private Double percentualDesconto;
    private BigDecimal precoPor;
    private BigDecimal precoDe;
    private BigDecimal valorDesconto;
    private String descricaoPromocao;
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private Boolean aplicado;

}
