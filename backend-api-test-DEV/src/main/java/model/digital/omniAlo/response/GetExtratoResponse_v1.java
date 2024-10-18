package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExtratoResponse_v1 {
    private BigDecimal saldoTotal;
    private BigDecimal valorParaResgate;
    private List<Integer> dataInicial;
    private List<Integer> dataFinal;
    private List<GetExtratoResponse_v1_SaldoMensalResponse> saldoMensal;
    private List<GetExtratoResponse_v1_MovimentacaoPontoResponse> movimentacao;
}
