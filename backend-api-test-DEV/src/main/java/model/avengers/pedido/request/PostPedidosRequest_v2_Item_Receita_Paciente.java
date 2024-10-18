package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item_Receita_Paciente {
    private String nome;
    private String dataNascimento;
    private String sexo;
    private Integer idade;
}
