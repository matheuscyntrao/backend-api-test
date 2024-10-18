package model.digital.shoppingCart.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DigitalPrescription {
   private Long id;
   private List<Long> items;
   private String platform;
   private String prescriptionType;
   private String token;
}
