package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosIdentificadorclienteHistoricoResponse_v1 {
    private List<GetPedidosIdentificadorclienteHistoricoResponse_v1_Historico> abertos;
    private List<GetPedidosIdentificadorclienteHistoricoResponse_v1_Historico> fechados;
    private List<GetPedidosIdentificadorclienteHistoricoResponse_v1_Historico> cancelados;
}
