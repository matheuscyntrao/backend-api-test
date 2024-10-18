package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_Cliente_DadosFidelidade {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenioFidelidade;
    private BigInteger codigoAssociadoFidelidade;
    private String matriculaFidelidade;
}
