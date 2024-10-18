package model.domino.filial.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFiliaisEstoqueResponseV1Itens {
    private Integer codigoItem;
    private Integer estoqueLoja;
    private Integer estoqueApoio;
    private Integer reservaVirtual;
    private Integer estoqueCd;
    private Integer estoqueCdApoio;
}