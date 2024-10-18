package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosIdentificadorclienteHistoricoResponse_v1_Historico_DescricaoEntrega {
    private Integer codigoTipoEntrega;
    private String descricaoTipoEntrega;
    private Integer codigoFormaEntrega;
    private String descricaoFormaEntrega;
    private String dataHoraEfetiva;
    private String dataHoraParaEntrega;
    private String dataHoraSaidaRota;
}
