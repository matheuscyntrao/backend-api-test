package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_Item_Pack {
    private BigInteger codigoPack;
    private String tipoItemPack;
    private Integer numeroItemPack;
    private BigDecimal aporteTradePack;
    private BigDecimal aporteExtraPack;
    private BigDecimal aporteFornecedorPack;
}
