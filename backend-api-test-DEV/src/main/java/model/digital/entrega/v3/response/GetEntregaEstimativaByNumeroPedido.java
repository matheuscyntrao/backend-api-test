package model.digital.entrega.v3.response;

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
public class GetEntregaEstimativaByNumeroPedido {
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime entregaEstimada;
}
