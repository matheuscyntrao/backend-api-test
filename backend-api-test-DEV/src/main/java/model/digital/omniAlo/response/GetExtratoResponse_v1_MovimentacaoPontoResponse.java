package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExtratoResponse_v1_MovimentacaoPontoResponse {
    private LocalDate data;
    private Long loja;
    private Long codigoOperacao;
    private String descricaoOperacao;
    private Character natureza;
    private BigDecimal pontos;
}

