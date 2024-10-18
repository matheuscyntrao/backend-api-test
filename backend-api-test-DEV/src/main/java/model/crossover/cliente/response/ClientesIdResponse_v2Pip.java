package model.crossover.cliente.response;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class ClientesIdResponse_v2Pip {
    private Integer origem;
    private BigInteger codEntidadeComercial;
    private String tipo;
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
    private String orgaoEmissorRg;
    private Boolean atualizacaoFidelidade;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private BigInteger matriculaAssociado;
    private Boolean permiteVendaCheque;
    private String dataUltimaAlteracao;
    private List<ClientesIdResponse_v2Pip_Contato> contatos;
    private List<ClientesIdResponse_v2Pip_Endereco> enderecos;
    private ClientesIdResponse_v2Pip_Usuario usuario;
}
