package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidosNumeropedidoItemdigitadoRequest_v2 {
    private BigInteger codigoItem;
    private Boolean itemDigitado;
}
