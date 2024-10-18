package model.domino.filial.response;

import lombok.Data;

@Data
public class GetFilialCepResponseV1Servico {
    private String filialTeleEntrega;
    private Boolean filialDelivery;
    private String manipulaFormulas;
    private String possuiAmbulatorio;
    private String atendimento24Horas;
    private String atendimentoTele24Horas;
    private String atendimentoExpress24Horas;
    private String atendimentoFeriado24Horas;
    private String farmaciaPopular;
    private String estacionamento;
    private String destinoCerto;
    private String verificaPressao;
    private String verificaGlicemia;
    private String aplicaMedicacao;
    private String verificaTemperatura;
    private String colocaBrinco;
    private String medidaCorporalIMC;
    private String avaliaCardio;
    private String revisaMedicacao;
    private String primeiroTratamento;
    private String sempreBem;
    private String laudoFarmaceutico;
    private String progAcompTratamento;
    private String progPerdaPeso;
    private String progPararFumar;
    private String testesLaboratoriaisRapidos;
    private String salaVacinas;
}
