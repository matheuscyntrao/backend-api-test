package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Entrega {
    private Integer codigoFormaEntrega;
    private Integer codigoTipoEntrega;
    private String cpfRetiradaBalcao;
    private BigInteger codigoRota;
    private String dataHoraEntrega;
    private String dataHoraSaidaRota;
    private BigInteger codigoTaxa;
    private String tipoTaxa;
    private BigDecimal valorTaxa;
    private Integer numeroItem;
    private BigInteger codigoLiberadorTaxa;
    private String convenioPagaTaxa;
    private String origemDesvioEstoque;
}
