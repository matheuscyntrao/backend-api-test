package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Item_Liberador {
    private BigInteger codigoLiberador;
    private String motivoLiberacao;
    private Integer idTransacao;
}
