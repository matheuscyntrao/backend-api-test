package model.crossover.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostClienteRequest_v2 {
    private Long codEntidadeComercial;
    private String nome;
    private String cpf;
    private String cnpj;
    private String dtNascimento;
    private String sexo;
    private Integer estadoCivil;
    private String receberNewsletter;
    private String emailAlternativo1;
    private String emailAlternativo2;
    private String rg;
    private List<PostClienteRequest_v2_Contatos> contatos;
    private List<PostClienteRequest_v2_Enderecos> enderecos;
    private PostClienteRequest_v2_Usuario usuario;
}
