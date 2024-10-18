package entity.domino.puc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsValidatorEntity_wallet_treatment {
    private Integer amount;
    private String compositionUnit;
    private String frequencyUnit;
    private Integer frequency;
}
