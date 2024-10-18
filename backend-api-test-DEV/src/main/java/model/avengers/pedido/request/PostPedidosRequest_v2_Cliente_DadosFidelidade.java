package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Cliente_DadosFidelidade {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenioFidelidade;
    private BigInteger codigoAssociadoFidelidade;
    private String matriculaFidelidade;
}
