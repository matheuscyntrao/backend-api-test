package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Item_Desconto {
    private BigDecimal valorDesconto;
    private String tipoDesconto;
    private Double percentualDesconto;
    private Integer origemDesconto;
    private PostPedidosRequest_v2_Item_Desconto_ConvenioAVista convenioAvista;
    private Integer idTransacao;
}
