package model.timeB.pbm.response;

import lombok.Data;

@Data
public class CampoPacienteResponse_v4 {
    private Integer codigoCampo;
    private String campo;
    private String nomeExibicao;
    private String entidade;
    private String tipo;
    private String descricao;
    private String exibicao;
    private OpcaoResponse_v4 opcoes[];
}
