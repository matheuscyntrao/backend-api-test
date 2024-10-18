package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item_Receita_Convenio {
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
}
