package model.digital.autenticacao.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String email;
    private Boolean necessitaAlterarLoginDigital;
}
