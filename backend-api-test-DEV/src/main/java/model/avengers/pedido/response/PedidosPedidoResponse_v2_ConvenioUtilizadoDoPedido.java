package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_ConvenioUtilizadoDoPedido {
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
