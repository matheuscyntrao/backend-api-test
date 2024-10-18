package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item_Pack {
    private BigInteger codigoPack;
    private String tipoItemPack;
    private Integer numeroItemPack;
    private BigDecimal aporteTradePack;
    private BigDecimal aporteExtraPack;
    private BigDecimal aporteFornecedorPack;
}
