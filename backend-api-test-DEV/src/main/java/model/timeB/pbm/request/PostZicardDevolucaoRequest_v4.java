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
public class PostZicardDevolucaoRequest_v4 {
    private String nsuConfirmacao;
    private String identificadorTransacao;
    private String cpfResponsavel;
    private String cnpjEstabelecimento;
    private String estacao;
    private List<PostZicardDevolucaoRequest_v4_Itens> itens;
}
