package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2_FormaPagamentoCheque {
    private Integer sequenciaCheque;
    private BigInteger codigoInstituicaoFinanceira;
    private String digitoAgencia;
    private BigInteger codigoAgencia;
    private BigInteger numeroContaBancaria;
    private String digitoContaBancaria;
    private BigInteger numeroCheque;
    private BigInteger filial;
    private String dataCompensacao;
    private String numeroCmc7;
    private String cpf;
    private String cgc;
    private Boolean inseridoManual;
    private String nsuTransacao;
    private BigInteger codigoCliente;
    private Integer codigoCondicaoPagamento;
    private Integer sequenciaCondicaoPagamento;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
