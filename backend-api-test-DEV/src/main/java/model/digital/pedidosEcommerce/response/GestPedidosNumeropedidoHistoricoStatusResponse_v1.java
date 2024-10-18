package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GestPedidosNumeropedidoHistoricoStatusResponse_v1 {
    private Integer codigoSituacao;
    private String situacao;
    private String dataSituacao;
}
