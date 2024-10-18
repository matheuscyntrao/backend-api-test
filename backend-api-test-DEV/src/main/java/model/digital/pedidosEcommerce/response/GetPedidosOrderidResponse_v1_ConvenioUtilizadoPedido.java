package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_ConvenioUtilizadoPedido {
    private Integer sequenciaConvenioPedido;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private String numeroIin;
    private String numeroDoCartao;
    private String numeroCartaoConvenio;
    private Boolean trocaSacolaPonto;
    private BigInteger convCodigoFilialConvenio;
    private BigInteger convCodigoConvenio;
}
