package model.crossover.cliente.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetClientePipClientesCpfResponse_v2 {
    private Integer origem;
    private Long codEntidadeComercial;
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
    private Long codigoFilialConvenio;
    private Long codigoConvenio;
    private Long codigoAssociado;
    private Long matriculaAssociado;
    private Boolean permiteVendaCheque;
    private String dataUltimaAlteracao;
    private List<GetClientePipClientesCpfResponse_v2_Contato> contatos;
    private List<GetClientePipClientesCpfResponse_v2_Endereco> enderecos;
    private GetClientePipClientesCpfResponse_v2_Usuario usuario;
}
