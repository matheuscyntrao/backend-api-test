package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_Recarga {
    private BigInteger filialConvenio;
    private BigInteger codigoConvenio;
    private BigInteger telefoneConvenio;
    private String nsu;
}
