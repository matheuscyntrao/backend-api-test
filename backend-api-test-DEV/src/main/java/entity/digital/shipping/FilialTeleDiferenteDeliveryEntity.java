package entity.digital.shipping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilialTeleDiferenteDeliveryEntity {
    private String cep;
    private Long FilialTele;
    private Long FilialDelivery;
}
