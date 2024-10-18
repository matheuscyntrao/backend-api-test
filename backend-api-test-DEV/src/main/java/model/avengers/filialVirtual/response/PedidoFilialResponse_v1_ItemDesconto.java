package model.avengers.filialVirtual.response;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
public class PedidoFilialResponse_v1_ItemDesconto {
    private BigDecimal valorDesconto;
    private String tipoDesconto;
    private Double percentualDesconto;
    private Integer origemDesconto;
}
