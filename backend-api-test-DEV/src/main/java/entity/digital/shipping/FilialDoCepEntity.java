package entity.digital.shipping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilialDoCepEntity {
    private String cep;
    private Long codigoFilial;
    private Long placeCode;
}
