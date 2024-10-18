package model.avengers.filialVirtual.response;

import lombok.Data;

@Data
public class PedidoFilialResponse_v1_Entrega {
    private Integer codigoFormaEntrega;
    private Integer codigoTipoEntrega;
    private String dataHoraEntrega;
    private Integer codigoTaxa;
    private Double valorTaxa;
    private Integer numeroItem;
}
