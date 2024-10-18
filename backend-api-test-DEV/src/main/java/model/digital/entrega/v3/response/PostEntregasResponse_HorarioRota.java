package model.digital.entrega.v3.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostEntregasResponse_HorarioRota {
    private Long codigoRota;
    private String dataInicial;
    private String dataFinal;
}
