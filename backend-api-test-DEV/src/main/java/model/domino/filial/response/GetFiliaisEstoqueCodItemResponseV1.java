package model.domino.filial.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFiliaisEstoqueCodItemResponseV1 {
    private Integer filial;
    private String nomeFilial;
    private Integer horarioAbertura;
    private Integer horarioFechamento;
    private String telefone;
    private Integer estoqueDisponivel;
    @Valid
    private GetFiliaisEstoqueCodItemResponseV1Endereco endereco;
    private Double distanciaAteFilial;
}
