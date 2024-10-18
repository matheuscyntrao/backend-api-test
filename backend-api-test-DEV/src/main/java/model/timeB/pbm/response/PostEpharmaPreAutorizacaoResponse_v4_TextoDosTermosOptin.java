package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEpharmaPreAutorizacaoResponse_v4_TextoDosTermosOptin {
    private String status;
    private String mensagem;
    private String linkTermos;
    private String textoTermos;
    private String codigoEnvio;

}
