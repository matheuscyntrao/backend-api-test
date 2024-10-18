package model.plataforma.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProducerPedidoAnalisado_ClearSale {
    private String code;
    private String status;
    private Double score;
}
