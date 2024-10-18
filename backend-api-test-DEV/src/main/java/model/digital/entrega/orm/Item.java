package model.digital.entrega.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer codigo;
    private Integer quantidade;
    private Integer quantidadeEntregar;
    private Boolean isPack;
}
