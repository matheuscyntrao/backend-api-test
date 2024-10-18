package model.digital.panvelEcommerceBff.campaign.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandPage {
      private String aplicacao;
      private String dataInicial;
      private Long id;
      private String link;
      private String tipo;
}
