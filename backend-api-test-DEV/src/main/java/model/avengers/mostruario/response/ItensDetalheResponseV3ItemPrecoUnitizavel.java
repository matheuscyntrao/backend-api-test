package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItensDetalheResponseV3ItemPrecoUnitizavel {
    private ItensDetalheResponseV3ItemPrecoUnitizavelQuantidadeComposicao quantidadeComposicao;
    private BigDecimal precoUnidade;
}
