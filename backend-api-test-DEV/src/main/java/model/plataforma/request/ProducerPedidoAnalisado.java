package model.plataforma.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProducerPedidoAnalisado {
    private String antifraudType;
    private ProducerPedidoAnalisado_ClearSale clearSaleNotification;
    private ProducerPedidoAnalisado_Konduto kondutoNotification;
}
