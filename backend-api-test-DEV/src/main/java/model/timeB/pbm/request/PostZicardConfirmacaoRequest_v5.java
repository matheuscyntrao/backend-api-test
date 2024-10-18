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
public class PostZicardConfirmacaoRequest_v5 {
    private Long cnpj;
    private String estacao;
    private String numeroCupom;
    private List<PostZicardConfirmacaoRequest_v5_Autorizacoes> autorizacoes;
}
