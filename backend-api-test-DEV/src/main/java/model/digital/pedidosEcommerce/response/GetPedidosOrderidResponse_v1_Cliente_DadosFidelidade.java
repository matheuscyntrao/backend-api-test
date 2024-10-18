package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Cliente_DadosFidelidade {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenioFidelidade;
    private BigInteger codigoAssociadoFidelidade;
    private String matriculaFidelidade;
}
