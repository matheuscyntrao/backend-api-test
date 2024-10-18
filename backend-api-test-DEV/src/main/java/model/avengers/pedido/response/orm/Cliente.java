package model.avengers.pedido.response.orm;

import lombok.Data;

@Data
public class Cliente {

    private Integer codigoCliente;
    private String nome;
    private String ddd;
    private String telefone;
    private String ramal;
    private String cpf;
    private String cnpj;
    private String dddRastreio;
    private String telefoneRastreio;
    private DadosFidelidade dadosFidelidade;
    private String email;

}
