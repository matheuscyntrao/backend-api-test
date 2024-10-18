package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_Item_Receita_ReceitaEletronica {
    private BigInteger id;
    private String token;
    private String nomePlataforma;
    private Integer tipoReceituario;
}
