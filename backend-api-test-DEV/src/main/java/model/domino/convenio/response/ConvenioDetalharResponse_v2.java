package model.domino.convenio.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConvenioDetalharResponse_v2 {
    private String nome;
    private String numeroCartao;
    private Integer codigo;
    private Integer filial;
    private Boolean possuiAssociado;
    private Boolean utilizaCartao;
    private String tipoPagamento;
    private Integer modoConvenio;
    private BigDecimal saldo;
    private Boolean permiteCombinarConvenio;
    private Boolean permiteVenderParaDependente;
    private Boolean permiteDigitarCartao;
    private Boolean utilizaSenha;
    private Boolean liberaSenha;
    private ConvenioDetalhar_v2_Associado associado;
    private Boolean permiteMultiplasFormas;
    private Integer permitePbm;
    private Integer identificacaoAssociado;
    private Boolean bloqueioPrimeiraCompra;
    private Boolean permiteCombinarConvenioPbm;
    private String pagamentoTaxaEntrega;
    private Boolean empresaCartao;
    private Boolean consultaApiEntidade;
    private Boolean consultaApiAutorizacao;
    private Boolean cartaoBloqueado;
    private Boolean solicitaSenhaDesconto;
    private Boolean necessitaCadastramentoSenha;
    private String melhorDiaCompra;
    private BigDecimal totalCompra;
}
