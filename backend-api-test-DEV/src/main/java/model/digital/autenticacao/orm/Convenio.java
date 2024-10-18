package model.digital.autenticacao.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Convenio {
    private Integer codigo;
    private String descricao;
    private Integer tipoPagamento;
    private Integer saldoConvenio;
    private String cartao;
    private List<Benefcio> beneficios;
}
