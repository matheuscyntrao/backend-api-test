package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Entrega {
    private BigInteger codigoFormaEntrega;
    private BigInteger codigoTipoEntrega;
    private String cpfRetiradaBalcao;
    private BigInteger codigoRota;
    private String dataHoraEntrega;
    private String dataHoraSaidaRota;
    private BigInteger codigoTaxa;
    private String tipoTaxa;
    private BigDecimal valorTaxa;
    private BigDecimal codigoLiberadorTaxa;
    private String convenioPagaTaxa;
    private BigInteger idLocker;
    private BigInteger numeroPortaLocker;
    private String numeroReservaLocker;
    private String senhaReservaLocker;
    private String origemDesvioEstoque;
}
