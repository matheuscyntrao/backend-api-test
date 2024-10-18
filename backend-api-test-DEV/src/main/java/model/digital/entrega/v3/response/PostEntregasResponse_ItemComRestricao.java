package model.digital.entrega.v3.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostEntregasResponse_ItemComRestricao {
    private Integer codigoItem;
    private String restricao;
}
