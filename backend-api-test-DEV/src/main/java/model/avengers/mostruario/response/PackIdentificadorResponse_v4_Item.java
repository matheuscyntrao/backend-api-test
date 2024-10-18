package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackIdentificadorResponse_v4_Item {
    private Integer codigoItem;
    private BigDecimal precoBase;
    private BigDecimal precoPromo;
    private Integer numeroPack;
    private Integer quantidade;
    private BigDecimal valorAporteFornecedor;
    private BigDecimal percentualDesconto;
}
