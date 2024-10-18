package model.avengers.mostruario.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItensDetalheRequest_v3_ConsultaRegrasFiscais {
    private String uf;
    private String pais;
    private String ufDestino;
    private String paisDestino;

    public ItensDetalheRequest_v3_ConsultaRegrasFiscais createConsultaRegrasFiscaisSp(Integer filial){
        return ItensDetalheRequest_v3_ConsultaRegrasFiscais.builder()
                .uf("RS")
                .pais("BR")
                .ufDestino("SP")
                .paisDestino("BR")
                .build();
    }
}
