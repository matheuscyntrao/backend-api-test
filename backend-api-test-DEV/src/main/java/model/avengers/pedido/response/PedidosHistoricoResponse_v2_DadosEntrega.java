package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosHistoricoResponse_v2_DadosEntrega {
    private Integer codigoTipoEntrega;
    private String descricaoTipoEntrega;
    private Integer codigoFormaEntrega;
    private String descricaoFormaEntrega;
    private String dataHoraEfetiva;
    private String dataHoraParaEntrega;
    private String dataHoraSaidaRota;
}
