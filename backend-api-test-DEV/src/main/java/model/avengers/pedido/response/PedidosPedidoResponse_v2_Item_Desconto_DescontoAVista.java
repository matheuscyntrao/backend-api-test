package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Item_Desconto_DescontoAVista {
    private BigInteger convCodigoFilialConvenio;
    private BigInteger convCodigoConvenio;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private String numeroIin;
    private String numeroDoCartao;
    private String numeroCartaoConvenio;
}
