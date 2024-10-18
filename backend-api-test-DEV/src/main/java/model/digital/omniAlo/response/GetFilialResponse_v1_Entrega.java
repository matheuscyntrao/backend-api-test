package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFilialResponse_v1_Entrega {
    private Integer codigo;
    private String tipoDeEntrega;
    private Long codigoTipoDeEntrega;
}

