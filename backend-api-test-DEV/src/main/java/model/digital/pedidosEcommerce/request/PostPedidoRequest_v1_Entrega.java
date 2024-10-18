package model.digital.pedidosEcommerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostPedidoRequest_v1_Entrega {
    private Long codigoFormaEntrega;
    private Long codigoTipoEntrega;
    private String cpfRetiradaBalcao;
    private Long codigoRota;
    private String dataHoraEntrega;
    private String dataHoraSaidaRota;
    private Long codigoTaxa;
    private String tipoTaxa;
    private BigDecimal valorTaxa;
    private Long codigoLiberadorTaxa;
    private String convenioPagaTaxa;
    private Long idLocker;
    private Long numeroPortaLocker;
    private String numeroReservaLocker;
    private String senhaReservaLocker;
    private String origemDesvioEstoque;
}
