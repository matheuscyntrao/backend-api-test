package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_Item_Receita_Comprador {
    private String cpf;
    private String rg;
    private String rgOrgaoEmissor;
    private String pais;
    private String uf;
    private String nome;
    private BigInteger numeroTelefone;
    private Integer dddTelefone;
    private PostPedidoRequest_v1_Item_Receita_Comprador_Endereco endereco;
}
