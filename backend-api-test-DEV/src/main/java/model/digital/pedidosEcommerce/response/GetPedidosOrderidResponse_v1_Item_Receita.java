package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_Item_Receita {
    private Integer numeroItem;
    private BigInteger numeroItemComReceita;
    private String dataReceita;
    private Integer quantidadeReceitada;
    private String numeroRegistro;
    private Integer tipoProfissional;
    private String siglaPais;
    private String siglaUf;
    private BigInteger codigoMedico;
    private BigInteger sequenciaEnderecoMedico;
    private BigInteger codigoFilialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger codigoAssociado;
    private String matriculaAssociado;
    private BigInteger codigoOperador;
    private String numeroLote;
    private String vendaAntecipada;
    private String situacao;
    private String tipoCaptacao;
    private String numeroNotificacao;
    private String ufNotificacao;
    private String nomePaciente;
    private String sexo;
    private String dataNascimento;
    private String cpfCliente;
    private String rgCliente;
    private String orgaoEmissorRg;
    private String siglaPaisEmissor;
    private String siglaUfEmissor;
    private String dddCliente;
    private String foneCliente;
    private String nomeCliente;
    private String nomeLogradouroCli;
    private BigInteger numeroEnderecoCli;
    private BigInteger idade;
    private String complementoEnderecoCli;
    private String cepCli;
    private String nomeBairroCli;
    private String nomeLocalidadeCli;
    private Integer codigoModeloReceita;
    private BigInteger codigoFuncionario;
    private String complementoNotificacao;
    private GetPedidosOrderidResponse_v1_Item_Receita_ReceitaEletronica receitaEletronica;
}
