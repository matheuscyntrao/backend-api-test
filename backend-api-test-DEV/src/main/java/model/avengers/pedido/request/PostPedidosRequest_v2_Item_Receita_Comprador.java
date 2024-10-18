package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item_Receita_Comprador {
    private String cpf;
    private String rg;
    private String rgOrgaoEmissor;
    private String pais;
    private String uf;
    private String nome;
    private BigInteger numeroTelefone;
    private Integer dddTelefone;
    private PostPedidosRequest_v2_Item_Receita_Comprador_Endereco endereco;
}
