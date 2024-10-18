package model.digital.entrega.v3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCorreiosResponse {
    private Integer prazoEntrega;
    private String servicoEntregaEnum;
    private Double valor;
}
