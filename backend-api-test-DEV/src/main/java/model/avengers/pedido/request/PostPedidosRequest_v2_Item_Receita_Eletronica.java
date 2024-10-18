package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item_Receita_Eletronica {
    private BigInteger id;
    private String token;
    private String nomePlataforma;
    private Integer tipoReceituario;
}
