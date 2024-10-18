package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExtratoResponse_v1_SaldoMensalResponse {
    private Integer mes;
    private Integer ano;
    private BigDecimal pontos;
}
