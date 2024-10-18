package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Item_PlanoBeneficioMedico {
    private BigInteger codigoConvenioPbm;
    private String preAutorizacaoPbm;
    private String identificadorTransacao;
}
