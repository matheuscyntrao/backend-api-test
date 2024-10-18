package entity.domino.puc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsValidatorEntity_wallet {
    private Long code;
    private String programCode;
    private ItemsValidatorEntity_wallet_treatment treatment;
    private Instant inclusionDate;
    private Instant exclusionDate;
}
