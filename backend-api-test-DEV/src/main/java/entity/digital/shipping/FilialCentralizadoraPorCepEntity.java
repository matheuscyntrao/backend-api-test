package entity.digital.shipping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilialCentralizadoraPorCepEntity {
    private String cep;
    private Long filial_centralizadora;
    private Long filial;
}