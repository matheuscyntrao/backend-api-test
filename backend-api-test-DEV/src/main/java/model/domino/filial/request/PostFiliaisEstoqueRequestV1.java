package model.domino.filial.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFiliaisEstoqueRequestV1 {
    private List<Integer> filiais;
    private List<Integer> itens;
}