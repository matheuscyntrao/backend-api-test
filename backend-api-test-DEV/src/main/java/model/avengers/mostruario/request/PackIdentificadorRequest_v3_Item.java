package model.avengers.mostruario.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackIdentificadorRequest_v3_Item {
    private Integer codigoItem;
    private Integer quantidade;
    private BigDecimal precoDe;
    private BigDecimal precoPor;

}
