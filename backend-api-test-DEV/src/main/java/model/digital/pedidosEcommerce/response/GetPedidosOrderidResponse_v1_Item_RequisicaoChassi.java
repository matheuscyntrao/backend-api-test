package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Item_RequisicaoChassi {
    private BigInteger codigoRequisicao;
    private Integer numeroItemReq;
    private BigInteger codigoTga;
    private String senhaEvento;
    private BigInteger idItemAgendamento;
    private BigInteger codigoBarraFornecedor;
}
