package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Doacao {
    private Double codOperacaoCaixa;
    private BigDecimal valorDoacao;
}
