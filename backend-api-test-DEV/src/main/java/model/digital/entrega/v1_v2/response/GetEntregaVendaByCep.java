package model.digital.entrega.v1_v2.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.entrega.v1_v2.response.orm.EntregaVenda;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetEntregaVendaByCep {
    private List<EntregaVenda> entregaVendaList;
}
