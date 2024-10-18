package model.timeB.pbm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostAutorizacaoRequest_v4 {
    private String nsuPreAutorizacao;
    private String identificadorTransacao;
}
