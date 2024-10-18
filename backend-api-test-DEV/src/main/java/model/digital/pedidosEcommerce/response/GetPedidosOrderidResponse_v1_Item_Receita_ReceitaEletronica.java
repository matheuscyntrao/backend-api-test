package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Item_Receita_ReceitaEletronica {
    private BigInteger id;
    private String token;
    private String nomePlataforma;
    private Integer tipoReceituario;
}
