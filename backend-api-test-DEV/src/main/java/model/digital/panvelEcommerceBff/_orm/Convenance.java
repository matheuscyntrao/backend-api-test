package model.digital.panvelEcommerceBff._orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Convenance {
    private String cardNumber;
    private Long code;
    private Long codigoFilialConvenio;
    private String registration;
}
