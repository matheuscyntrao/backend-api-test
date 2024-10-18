package model.digital.entrega.v1_v2.response.orm;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.json.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorarioRota {
    private String sequencia;
    private Integer codigoRota;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataInicial;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataFinal;
}
