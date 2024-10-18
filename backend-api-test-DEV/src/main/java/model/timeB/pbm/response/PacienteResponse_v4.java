package model.timeB.pbm.response;

import lombok.Data;

@Data
public class PacienteResponse_v4 {
    private Integer codigoPaciente;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private Boolean titular;
}
