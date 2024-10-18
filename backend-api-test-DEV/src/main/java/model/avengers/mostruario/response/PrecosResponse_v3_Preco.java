package model.avengers.mostruario.response;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PrecosResponse_v3_Preco {
   @NotNull
   private BigDecimal precoVenda;
   private BigDecimal precoPor;
   private BigDecimal precoFidelidade;
   private BigDecimal precoFidelidade55Mais;
   
}
