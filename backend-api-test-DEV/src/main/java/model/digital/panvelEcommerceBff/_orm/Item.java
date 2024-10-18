package model.digital.panvelEcommerceBff._orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String panvelCode;
    private Prescription prescription;
}
