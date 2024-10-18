package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Item_Receita_Comprador_Endereco {
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String complemento;
    private Integer cep;
    private String cidade;
}
