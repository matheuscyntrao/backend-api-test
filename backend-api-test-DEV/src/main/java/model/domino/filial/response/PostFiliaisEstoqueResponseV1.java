package model.domino.filial.response;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class PostFiliaisEstoqueResponseV1 {
    private Integer filial;
    @Valid
    private List<PostFiliaisEstoqueResponseV1Itens> itens;
}