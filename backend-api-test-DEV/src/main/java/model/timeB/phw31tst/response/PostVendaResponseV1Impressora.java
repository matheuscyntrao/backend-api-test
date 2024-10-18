package model.timeB.phw31tst.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostVendaResponseV1Impressora {
    private Integer codigo;
    private Integer codigoIntervencao;
}