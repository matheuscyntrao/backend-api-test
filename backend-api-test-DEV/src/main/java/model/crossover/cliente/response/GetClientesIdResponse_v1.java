package model.crossover.cliente.response;

import lombok.Data;
import utils.PatternRegex;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;

@Data
public class GetClientesIdResponse_v1 {
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
    @Valid
    private GetClientesIdResponse_v1_Contato contatos[];
    @Valid
    private GetClientesIdResponse_v1_Endereco enderecos[];
    private BigInteger codigoFilialUltimaAlteracao;
    private BigInteger codigoCanalUltimaAlteracao;
    @Valid
    private GetClientesIdResponse_v1_Usuario usuario;

}
