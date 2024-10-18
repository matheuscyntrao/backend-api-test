package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Item_Desconto {
    private BigDecimal valorDesconto;
    private String tipoDesconto;
    private Double percentualDesconto;
    private Integer origemDesconto;
    private GetPedidosOrderidResponse_v1_Item_Desconto_Convenio convenioAvista;
}
