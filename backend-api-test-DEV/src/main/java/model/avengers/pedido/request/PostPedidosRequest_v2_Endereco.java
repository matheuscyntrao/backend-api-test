package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Endereco {
    private BigInteger codigoLocalidade;
    private BigInteger codigoLogradouro;
    private Integer numeroEndereco;
    private String complementoEndereco;
    private String referenciaEntrega;
}
