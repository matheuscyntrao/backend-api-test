package model.domino.filial.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFiliaisConsultaResponse_v1_Servicos {
    private Boolean manipulaFormulas;
    private Boolean atendimentoFeriado24Hrs;
    private Boolean farmaciaPopular;
    private Boolean possuiEstacionamento;
    private Boolean verificaPressao;
    private Boolean verificaGlicemia;
    private Boolean aplicaMedicamento;
    private Boolean verificaTemperatura;
    private Boolean colocaBrinco;
    private Boolean verificaMedidasImc;
    private Boolean verificaCardio;
    private Boolean progDestinoCerto;
    private Boolean progRevisaMedicacao;
    private Boolean progPrimeiroTratamento;
    private Boolean progSempreBem;
    private Boolean laudoFarmaceutico;
    private Boolean utilizaPanvelGo;
    private Boolean progAcompTratamento;
    private Boolean progPerdaPeso;
    private Boolean progPararFumar;
    private Boolean testesLabRapidos;
    private Boolean captacaoReceituario;
    private Boolean atendimento24Hrs;
    private Boolean possuiAmbulatorio;
    private Boolean filialDelivery;
    private Boolean possuiSalaVacina;
    private Boolean possuiAgendamentoClinica;
    private Boolean retiraTeleBalcao;
    private Boolean permitePedidoCd;
}
