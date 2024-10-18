package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_Item_Receita_Convenio {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
}
