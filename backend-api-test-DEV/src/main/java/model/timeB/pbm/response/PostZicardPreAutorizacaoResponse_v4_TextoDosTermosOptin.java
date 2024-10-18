package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostZicardPreAutorizacaoResponse_v4_TextoDosTermosOptin {
    private String status;
    private String mensagem;
    private String linkTermos;
    private String textoTermos;
    private String codigoEnvio;
}
