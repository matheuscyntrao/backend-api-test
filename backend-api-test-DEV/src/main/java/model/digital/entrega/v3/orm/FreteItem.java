package model.digital.entrega.v3.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FreteItem {
    private Integer item;
    private Boolean possuiFreteGratis;
}
