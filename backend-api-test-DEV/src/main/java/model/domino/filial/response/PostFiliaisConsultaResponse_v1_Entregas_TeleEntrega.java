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
public class PostFiliaisConsultaResponse_v1_Entregas_TeleEntrega {
    private Boolean possuiTeleEntrega;
    private Boolean teleAtiva;
    private Boolean atendimentoTele24Hrs;
    private Integer prazoSeparacao;
    private String aberturaFeriadoTele;
    private String fechamentoFeriadoTele;
    private String horarioAberturaTele;
    private String horarioFechamentoTele;
}
