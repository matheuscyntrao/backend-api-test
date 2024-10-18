package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pack {
    private Long code;
    private Long number;
    private Long sequence;
    private BigDecimal valorAporteExtra;
    private BigDecimal valorAporteFornecedor;
    private BigDecimal valorAporteTrade;
}
