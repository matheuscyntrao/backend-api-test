package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_RequisicaoCassi {
    private BigInteger codigoRequisicao;
    private Integer numeroItemReq;
    private BigInteger codigoTga;
    private String senhaEvento;
    private BigInteger idItemAgendamento;
    private BigInteger codigoBarraFornecedor;
}
