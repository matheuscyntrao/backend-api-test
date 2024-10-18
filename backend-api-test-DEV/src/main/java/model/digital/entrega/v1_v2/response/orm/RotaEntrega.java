package model.digital.entrega.v1_v2.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RotaEntrega {
    private Integer pk;
    private String descricaoRota;
    private Integer codigoFilial;
    private Integer prazoEntrega;
    private Float valorTaxa;
    private BigDecimal valorMinimo;
    private BigDecimal valorIsentaTaxa;
    private Integer tipoRota;
    private HoraRotaModel horaRotaModel;
}
