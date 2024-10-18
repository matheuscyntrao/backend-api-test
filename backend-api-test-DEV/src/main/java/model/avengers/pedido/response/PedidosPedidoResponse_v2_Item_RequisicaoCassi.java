package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Item_RequisicaoCassi {
    private Integer codigoRequisicao;
    private Integer numeroItemReq;
    private BigInteger codigoBarraFornecedor;
}
