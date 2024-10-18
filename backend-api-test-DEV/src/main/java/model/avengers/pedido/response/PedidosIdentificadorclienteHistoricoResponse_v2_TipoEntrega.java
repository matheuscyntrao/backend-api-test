package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosIdentificadorclienteHistoricoResponse_v2_TipoEntrega {
    private Integer codigoTipoEntrega;
    private String descricaoTipoEntrega;
    private Integer codigoFormaEntrega;
    private String descricaoFormaEntrega;
    private String dataHoraEfetiva;
    private String dataHoraParaEntrega;
    private String dataHoraSaidaRota;
}
