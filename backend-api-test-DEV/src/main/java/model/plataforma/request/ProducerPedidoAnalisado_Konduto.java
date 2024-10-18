package model.plataforma.request;

import lombok.Data;

@Data
public class ProducerPedidoAnalisado_Konduto {
    private String orderId;
    private Long timestamp;
    private String status;
    private String signature;
}
