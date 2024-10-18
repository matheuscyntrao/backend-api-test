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
public class PostFiliaisConsultaResponse_v1_Entregas_Express {
    private Boolean possuiAtendimentoExpress;
    private Boolean atendimentoExpress24Hrs;
    private BigDecimal valorTaxaExpress;
    private String aberturaFeriadoExpress;
    private String fechamentoFeriadoExpress;
    private String hrAbertExpress;
    private String hrFechaExpress;
}
