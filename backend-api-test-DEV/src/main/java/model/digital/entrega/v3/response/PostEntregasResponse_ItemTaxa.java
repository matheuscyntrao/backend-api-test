package model.digital.entrega.v3.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostEntregasResponse_ItemTaxa {
    private Long codigo;
    private Integer quantidade;
    private String tipoItemPedido;
    private BigDecimal valorTaxa;
}
