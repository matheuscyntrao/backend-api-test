package model.digital.entrega.v1_v2.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetEntregaTaxas {
    private Integer codigoTaxa;
    private Boolean isentaTaxa;
    private String tipoTaxa;
}
