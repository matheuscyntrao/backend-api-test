package model.digital.autenticacao.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Benefcio {
    private String descricao;
    private Integer percentualDesconto;
}
