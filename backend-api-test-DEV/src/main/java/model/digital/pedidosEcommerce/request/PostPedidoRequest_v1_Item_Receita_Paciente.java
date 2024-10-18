package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_Item_Receita_Paciente {
    private String nome;
    private String dataNascimento;
    private String sexo;
}
