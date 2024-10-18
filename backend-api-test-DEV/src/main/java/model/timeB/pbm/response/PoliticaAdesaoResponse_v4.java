package model.timeB.pbm.response;

import lombok.Data;

@Data
public class PoliticaAdesaoResponse_v4 {
    private Boolean obrigatorioPrescritor;
    private Boolean utilizaPacientes;
    private AvaliacaoEligibilidadeResponse_v4 avaliacaoElegibilidade;
    private PacienteResponse_v4 pacientes[];
    private CamposBeneficiariosResponse_v4 camposBeneficiario[];
    private CampoPacienteResponse_v4 camposPaciente[];
    private CampoProdutoResponse_v4 camposProduto[];
    private CampoExtraResponse_v4 camposExtras[];
}
