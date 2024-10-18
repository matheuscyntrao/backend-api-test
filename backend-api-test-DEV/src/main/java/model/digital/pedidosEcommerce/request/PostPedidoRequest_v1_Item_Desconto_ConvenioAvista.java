package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_Item_Desconto_ConvenioAvista {
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
