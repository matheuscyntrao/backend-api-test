package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_ConveniosUtilizados {
    private BigInteger convCodigoFilialConvenio;
    private BigInteger convCodigoConvenio;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private String numeroIin;
    private String numeroCartaoConvenio;
    private Boolean trocaSacolaPonto;
}