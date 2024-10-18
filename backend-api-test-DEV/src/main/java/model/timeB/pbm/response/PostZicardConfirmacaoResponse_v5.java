package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostZicardConfirmacaoResponse_v5 {
    private PostZicardConfirmacaoResponse_v5_Comprovante comprovante;
    private String nsuConfirmacao;

}
