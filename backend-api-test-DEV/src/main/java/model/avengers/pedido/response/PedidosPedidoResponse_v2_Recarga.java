package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2_Recarga {
    private BigInteger filialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger telefoneConvenio;
    private String nsu;
}
