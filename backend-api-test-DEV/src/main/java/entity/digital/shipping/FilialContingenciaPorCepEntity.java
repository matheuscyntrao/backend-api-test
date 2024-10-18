package entity.digital.shipping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilialContingenciaPorCepEntity {
    private String cep;
    private Long filial_contingencia;
    private Long filial;
}
