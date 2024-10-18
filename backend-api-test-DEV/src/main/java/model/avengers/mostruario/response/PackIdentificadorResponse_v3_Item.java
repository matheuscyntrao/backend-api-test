package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackIdentificadorResponse_v3_Item {
    private Integer codigoFilial;
    private Integer sequenciaItem;
    private Integer codigoItem;
    private BigDecimal precoBase;
    private BigDecimal precoPromo;
    private Integer numeroPack;
    private BigDecimal valorAporteFornecedor;
    private BigDecimal valorAporteTrade;
    private BigDecimal valorAporteExtra;
    private Double percentualDesconto;
}
