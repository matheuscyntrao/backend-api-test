package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItensDetalheResponseV3ItemPromocao {
    private Integer codigoPromocao;
    private Integer codigoFilialPromotora;
    private Integer perfil;
    private Double percentualDesconto;
    private String dataInicio;
    private String dataFinal;
    private String tipoPromocao;
    private String descricaoPromocao;
    private Integer codigoModalidade;
    private String descricaoModalidade;
    private BigDecimal aportes;

}
