package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Cliente_Fidelidade {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenioFidelidade;
    private BigInteger codigoAssociadoFidelidade;
    private String matriculaFidelidade;
}
