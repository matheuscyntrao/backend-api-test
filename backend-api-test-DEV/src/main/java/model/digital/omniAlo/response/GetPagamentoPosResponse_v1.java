package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPagamentoPosResponse_v1 {
    private List<GetPagamentoPosResponse_v1_Detail> formaPagamentoDebito;
    private List<GetPagamentoPosResponse_v1_Detail> formaPagamentoCreditoVista;
    private List<GetPagamentoPosResponse_v1_Detail> formaPagamentoCreditoParcelado;
    private List<GetPagamentoPosResponse_v1_Detail> formaPagamentoDebitoParcelado;
}
