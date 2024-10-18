package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Item_Receita_ReceitaEletronica {
    private BigInteger id;
    private String token;
    private String nomePlataforma;
    private Integer tipoReceituario;
}
