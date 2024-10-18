package model.domino.convenio.response;

import lombok.Data;

@Data
public class ConvenioDetalhar_v2_Associado {
    private String nome;
    private String cpf;
    private String matricula;
    private Integer codigo;
    private Boolean associadoBloqueado;
    private Boolean titular;
    private ConvenioDetalhar_v2_Associado_dependente dependente;

}
