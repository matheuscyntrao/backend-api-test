package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_Item_Desconto {
    private BigDecimal valorDesconto;
    private String tipoDesconto;
    private Double percentualDesconto;
    private Integer origemDesconto;
    private PostPedidoRequest_v1_Item_Desconto_ConvenioAvista convenioAvista;
}
