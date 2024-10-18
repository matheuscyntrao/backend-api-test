package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Item_PlanoBeneficioMedico {
    private BigInteger codigoConvenioPbm;
    private String preAutorizacaoPbm;
    private String identificadorTransacao;
    private BigInteger idConvenioPbm;
    private BigDecimal precoAquisicaoUnitario;
    private BigDecimal valorRepasse;
    private String numeroCartao;
}
