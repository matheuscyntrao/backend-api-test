package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Item_Liberador {
    private BigInteger codigoLiberador;
    private String motivoLiberacao;
}
