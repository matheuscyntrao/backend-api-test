package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Item_PlanoBeneficioMedico {
    private BigInteger codigoConvenioPbm;
    private String preAutorizacaoPbm;
    private String identificadorTransacao;
}
