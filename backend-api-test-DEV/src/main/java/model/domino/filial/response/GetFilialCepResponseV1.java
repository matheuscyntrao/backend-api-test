package model.domino.filial.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class GetFilialCepResponseV1 {
    private Integer filial;
    private String nomeFilial;
    private String cnpj;
    private String inscricaoEstadual;
    private Integer horarioAbertura;
    private Integer horarioFechamento;
    private String horarioAberturaFeriado;
    private String horarioFechamentoferiado;
    private String horarioAberturaFinalSemana;
    private String horarioFechamentoFinalSemana;
    private String horarioProximaAbertura;
    private String horarioAberturaClinic;
    private String horarioFechamentoClinic;
    private String possuiAgendamentoClinic;
    private Integer prazoSeparacaoTele;
    private String telefone;
    private String celular;
    private String centralAloPanvel;
    private String nomeAmigavel;
    @Valid
    private GetFilialCepResponseV1Endereco endereco;
    @Valid
    private GetFilialCepResponseV1Servico servico;
    private String origemDesvioEstoque;
    private String dataEntregaCD;
    private Integer logistica;
    private String filialPanvelGo;
    private Boolean filialAberta;
    private Boolean filialFuncionaNoDia;
}
