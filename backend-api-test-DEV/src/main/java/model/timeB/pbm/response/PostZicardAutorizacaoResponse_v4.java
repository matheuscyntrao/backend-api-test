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
public class PostZicardAutorizacaoResponse_v4 {
    private String numeroSessao;
    private String nsuAutorizacao;
    private String identificadorTransacao;
    private Boolean statusAutorizacao;
    private String cpfAtendimento;
    private List<PostZicardAutorizacaoResponse_v4_Itens> itens;
}
