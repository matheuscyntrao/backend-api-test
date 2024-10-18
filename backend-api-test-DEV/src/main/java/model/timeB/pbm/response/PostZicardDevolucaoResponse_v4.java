package model.timeB.pbm.response;

import lombok.Data;

@Data
public class PostZicardDevolucaoResponse_v4 {
    private PostZicardDevolucaoResponse_v4_Comprovante comprovante;
    private String codigoAutorizacao;
    private String dataTransacao;
}