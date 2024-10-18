package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_RequisicaoCassi {
    private BigInteger codigoRequisicao;
    private Integer numeroItemReq;
    private BigInteger codigoTga;
    private String senhaEvento;
    private BigInteger idItemAgendamento;
    private BigInteger codigoBarraFornecedor;
}
