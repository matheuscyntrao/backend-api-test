package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_FormaPagamentoCheque {
    private Integer sequenciaCheque;
    private BigInteger codigoInstituicaoFinanceira;
    private String digitoAgencia;
    private BigInteger codigoAgencia;
    private BigInteger numeroContaBancaria;
    private String digitoContaBancaria;
    private BigInteger numeroCheque;
    private BigInteger filial;
    private BigInteger codigoFormaPagamento;
    private String tipoPagamento;
    private BigDecimal valor;
    private Integer sequenciaFormaPagamento;
}
