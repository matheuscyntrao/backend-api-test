package model.digital.pedidosEcommerce.response;

import lombok.Data;

@Data
public class GetPedidosNumeropedidoHistoricoStatusResponde_v1 {
    private Integer codigoSituacao;
    private String situacao;
    private String dataSituacao;
}
