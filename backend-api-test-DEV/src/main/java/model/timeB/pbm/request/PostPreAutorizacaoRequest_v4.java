package model.timeB.pbm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostPreAutorizacaoRequest_v4 {
    private String numeroSessao;
    private String estacao;
    private Integer canalVenda;
    private Integer origemCanal;
    private Long codigoFilial;
    private String tipoPrograma;
    private String usuario;
    private String nsuPreAutorizacao;
    private String identificadorTransacao;
    private String cnpjOrigem;
    private String cpfBeneficiario;
    private String cpfAtendimento;
    private String cartaoBeneficiario;
    private String codigoPrograma;
    private Long sequenciaPrograma;
    private List<PostPreAutorizacaoRequest_v4_Item> itens;
}
