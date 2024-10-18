package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostAutorizacaoResponse_v1 {
    private String cartaoBeneficiario;
    private List<PostAutorizacaoResponse_v1_formaPagamento> formaPagamento;
    private String identificadorTransacao;
    private List<PostAutorizacaoResponse_v1_itens> itens;
    private String nsuAuthorization;
    private List<PostAutorizacaoResponse_v1_pacientes> pacientes;
    private Boolean solicitaReceita;
    private Boolean statusAutorizacao;
}
