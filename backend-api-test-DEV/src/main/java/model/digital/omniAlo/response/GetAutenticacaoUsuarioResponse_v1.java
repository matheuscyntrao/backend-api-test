package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAutenticacaoUsuarioResponse_v1 {
    private Long codigoUsuario;
    private Long codigoFuncionario;
    private String status;
    private Long codigoAloRecurso;
    private String nome;
}

