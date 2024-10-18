package model.avengers.filialVirtual.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilialVirtualResponse_v1_Supervisao {
    private Integer codigoAreaSupervisao;
    private Integer codigoSupervisor;
    private Integer codigoAreaGeral;
    private Integer codigoRegional;
    private String descricaoAreaSupervisao;
}
