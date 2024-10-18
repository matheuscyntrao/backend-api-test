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
public class PostFiliaisConsultaResponse_v1_Entregas {
    private Integer prazoEntrega;
    private Integer prazoEntregaInternet;
    private BigDecimal valorTaxaEntrega;
    private PostFiliaisConsultaResponse_v1_Entregas_TeleEntrega teleEntrega;
    private PostFiliaisConsultaResponse_v1_Entregas_Express express;
}
