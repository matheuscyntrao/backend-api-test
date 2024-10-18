package model.digital.autenticacao.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.autenticacao.orm.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostAutenticacao {
    private Integer codEntidadeComercial;
    private String tipo;
    private String nome;
    private String cpf;
    private LocalDateTime dtNascimento;
    private String sexo;
    private Integer estadoCivil;
    private String receberNewsletter;
    private Boolean permiteVendaCheque;
    private LocalDateTime dataUltimaAlteracao;
    private List<Contato> contatos;
    private List<Endereco> enderecos;
    private Usuario usuario;
    private TelefonePrincipal telefonePrincipal;
    private List<Convenio> convenios;
    private String primeiroNome;
    private Boolean colaborador;
    private List<EnderecoUltimoPedido> enderecoUltimoPedido;
    private AutenticacaoResponse autenticacaoResponse;
 }
